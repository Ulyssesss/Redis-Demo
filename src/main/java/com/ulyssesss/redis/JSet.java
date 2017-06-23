package com.ulyssesss.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by jiangyue on 2017/6/23.
 */
public class JSet {
    public static void main(String[] args) {
        String key = "teachers";
        Jedis jedis = new Jedis("localhost");

        Long saddResult1 = jedis.sadd(key, "John");
        System.out.println("sadd 命令1: " + saddResult1);

        Long saddResult2 = jedis.sadd(key, "Amy");
        System.out.println("sadd 命令2: " + saddResult2);

        Long saddResult3 = jedis.sadd(key, "Amy");
        System.out.println("sadd 命令3: " + saddResult3);

        Set<String> smembersResult = jedis.smembers(key);
        System.out.println("smembers 命令: " + smembersResult);

        boolean sismemberResult1 = jedis.sismember(key, "Amy");
        System.out.println("sismember 命令1: " + sismemberResult1);

        boolean sismemberResult2 = jedis.sismember(key, "Jack");
        System.out.println("sismember 命令2: " + sismemberResult2);

        Long sremResult1 = jedis.srem(key, "Amy");
        System.out.println("srem 命令1: " + sremResult1);

        Long sremResult2 = jedis.srem(key, "Amy");
        System.out.println("srem 命令2: " + sremResult2);

        System.out.println("srem 后的 teachers: " + jedis.smembers(key));
        jedis.del(key);
    }
}
