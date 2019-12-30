package pipeline;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Date;

/**
 * redis 一般是TCP协议  一般是一request 一 response 比较慢
 * pipeline就是 一次性就所有request 全部发给 服务器
 * 服务器依次执行 然后将结果打包 一次发给 Client端
 */
public class PipeLine1 {
    private static final String SERVER_ADDRESS = "localhost"; // 服务器地址
    private static final Integer SERVER_PORT = 6379; // 端口

    @Test //403ms
    public void fun1(){
        Jedis jedis = new Jedis(SERVER_ADDRESS,SERVER_PORT);
        Long start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            jedis.hset("key","field"+i,"value"+i);
        }
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
        jedis.flushAll();
        jedis.close();
    }
    @Test //80s
    public void fun2(){
        Jedis jedis = new Jedis(SERVER_ADDRESS,SERVER_PORT);
        //这样的方式拿到pipeline
        Pipeline p= jedis.pipelined();
//        Pipeline p = new Pipeline();
        Long start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            p.hset("key2","field2"+i,"value2"+i);
        }
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
        p.syncAndReturnAll();
        jedis.flushAll();
        jedis.close();
    }
}
