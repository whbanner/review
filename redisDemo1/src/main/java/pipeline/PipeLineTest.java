package pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Set;

public class PipeLineTest {
    private static final String SERVER_ADDRESS = "localhost"; // 服务器地址
    private static final Integer SERVER_PORT = 6379; // 端口
    public static void main(String[] args) {
        Jedis jedis = new Jedis(SERVER_ADDRESS, SERVER_PORT);
        Pipeline p = jedis.pipelined();
        p.set("r1", "bar");
        p.zadd("r2", 1, "barowitch");
        p.zadd("r2", 0, "barinsky");
        p.zadd("r2", 0, "barikoviev");
        Response<String> pipeString = p.get("r1");
        System.out.println(pipeString);
        Response<Set<String>> sose = p.zrange("r2", 0, -1);
        p.sync();
        int soseSize = sose.get().size();
        Set<String> setBack = sose.get();
        System.out.println(pipeString);
        System.out.println(soseSize);
        for(String str:setBack){
            System.out.println(str);
        }
        jedis.disconnect();

    }
}
