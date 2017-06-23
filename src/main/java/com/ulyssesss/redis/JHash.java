package com.ulyssesss.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by jiangyue on 2017/6/23.
 */
public class JHash {
    public static void main(String[] args) {
        String key = "student";
        Jedis jedis = new Jedis("localhost");

        Long hsetResult1 = jedis.hset(key, "name", "Jack");
        System.out.println("hset 命令1: " + hsetResult1);

        Long hsetResult2 = jedis.hset(key, "name", "Tony");
        System.out.println("hset 命令2: " + hsetResult2);

        Long hsetResult3 = jedis.hset(key, "age", "3");
        System.out.println("hset 命令3: " + hsetResult3);

        String hgetResult = jedis.hget(key, "name");
        System.out.println("hget 命令: " + hgetResult);

        Map<String, String> hgetallResult = jedis.hgetAll(key);
        System.out.println("hgetall 命令: " + hgetallResult);

        Long hdelResult = jedis.hdel(key, "age");
        System.out.println("hdel 命令: " + hdelResult);

        System.out.println("hdel 后的 student: " + jedis.hgetAll(key));
        jedis.del(key);
    }
}
