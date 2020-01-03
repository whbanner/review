package com.wh;

import com.wh.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    /**
     * Lettuce是个连接池 jedis在多线程时，多个线程共享一个实例 所以不安全
     * Lettuce的连接是基于Netty的，连接实例可以在多个线程间共享，
     * 一个多线程的应用可以使用同一个连接实例，而不用担心并发线程的数量。
     * 当然这个也是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。
     */
    @Bean
    RedisConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        //RedisTemplate默认JdkSerializtionRedisSerializer
        //StringRedisTemplate默认使用StringRedisSerializer
        //RedisTemplate能够让我们持久化各种类型的key和value，并不仅限于字节数组
        //StringRedisTemplate扩展了RedisTemplate，只能使用String类型
        //StringRedisTemplate有一个接受RedisConnectionFactory的构造器，因此没有必要在构建后在调用setConnectionFactory()
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(lettuceConnectionFactory());
        //序列化key以StringRedisSerializer的方式：序列化String类型的key和value
        template.setKeySerializer(new StringRedisSerializer());
        //序列化user对象 自定义序列化接口
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
