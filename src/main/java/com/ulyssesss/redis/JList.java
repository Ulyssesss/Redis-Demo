package com.ulyssesss.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by jiangyue on 2017/6/23.
 */
public class JList {
    public static void main(String[] args) {
        String key = "students";
        Jedis jedis = new Jedis("localhost");

        long rpushResult1 = jedis.rpush(key, "Jack");
        System.out.println("rpush 命令1: " + rpushResult1);

        long rpushResult2 = jedis.rpush(key, "Tony");
        System.out.println("rpush 命令2: " + rpushResult2);

        long lpushResult1 = jedis.lpush(key, "Judy");
        System.out.println("lpush 命令1: " + lpushResult1);

        long lpushResult2 = jedis.lpush(key, "Wade");
        System.out.println("lpush 命令2: " + lpushResult2);

        List<String> lrangeResult1 = jedis.lrange(key, 0, -1);
        System.out.println("lrange 命令1: " + lrangeResult1);

        List<String> lrangeResult2 = jedis.lrange(key, 0, -2);
        System.out.println("lrange 命令2: " + lrangeResult2);

        List<String> lrangeResult3 = jedis.lrange(key, 0, 2);
        System.out.println("lrange 命令3: " + lrangeResult3);

        String lindexResult = jedis.lindex(key, 1);
        System.out.println("lindex 命令: " + lindexResult);

        String lpopResult = jedis.lpop(key);
        System.out.println("lpop 命令: " + lpopResult);

        String rpopResult = jedis.rpop(key);
        System.out.println("rpop 命令: " + rpopResult);

        System.out.println("pop 后的 students: " + jedis.lrange(key, 0, -1));
        jedis.del(key);
    }
}
