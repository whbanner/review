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
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(lettuceConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
