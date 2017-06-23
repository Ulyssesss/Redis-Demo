package com.ulyssesss.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by jiangyue on 2017/6/23.
 */
public class JString {
    public static void main(String[] args) {
        String key = "name";
        Jedis jedis = new Jedis("localhost");

        String setResult = jedis.set(key, "Jack");
        System.out.println("SET 命令: " + setResult);

        String getResult = jedis.get(key);
        System.out.println("GET 命令: " + getResult);

        long delResult1 = jedis.del(key);
        System.out.println("DEL 命令1: " + delResult1);

        long delResult2 = jedis.del(key);
        System.out.println("DEL 命令2: " + delResult2);
    }
}
