import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/chai1230/article/details/79347154
 * https://www.jianshu.com/p/0bff715fd4f9
 * redis-server 显示already use
 * 用此命令  /etc/init.d/redis-server stop
 * 启动     /etc/init.d/redis-server start
 */
public class JedisDemo1 {
    /**
     * 单实例的测试
     */
    //REDIS 不同于 map关机开机之后还有
    @Test
    public void demo1(){
        // 1.设置IP地址和端口
        Jedis jedis = new Jedis("localhost",6379);
        // 2.保存数据
//        jedis.set("name","whhh");
        Map<String,String> map=new HashMap<>();
        map.put("username","wh");
        map.put("password","123");
        jedis.hmset("login",map);
        // 3.获取数据
//        String value = jedis.get("name");
        Map<String,String> map1=jedis.hgetAll("login");

        System.out.println(map1);

        // 4.释放资源
        jedis.close();
    }

    /**
     * 使用连接池方式连接
     */
    @Test
    public void demo2(){
        // 获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        // 获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        // 通过连接池获得连接
        Jedis jedis = jedisPool.getResource();
        // 设置数据
//        jedis.set("name","张三");
        // 获取数据
        String value = jedis.get("name");
        System.out.println(value);
        // 释放资源
        jedis.close();
        // 释放连接池
        jedisPool.close();

    }


}
