package com.ulyssesss.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Created by jiangyue on 2017/6/23.
 */
public class JZSet {
    public static void main(String[] args) {
        String key = "teachers";
        Jedis jedis = new Jedis("localhost");

        Long zaddResult1 = jedis.zadd(key, 100, "John");
        System.out.println("zadd 命令1: " + zaddResult1);

        Long zaddResult2 = jedis.zadd(key, 100, "Amy");
        System.out.println("zadd 命令2: " + zaddResult2);

        Long zaddResult3 = jedis.zadd(key, 10, "John");
        System.out.println("zadd 命令3: " + zaddResult3);

        Set<String> zrangeResult = jedis.zrange(key, 0, -1);
        System.out.println("zrange 命令: " + zrangeResult);

        Set<String> zrangebyscoreResult = jedis.zrangeByScore(key, 0, 15);
        System.out.println("zrangebyscore 命令: " + zrangebyscoreResult);

        Set<Tuple> zrangebyscorewithscoresResult = jedis.zrangeByScoreWithScores(key, 0, 200);
        System.out.println("zrangebyscorewithscores 命令: ");
        for (Tuple tuple : zrangebyscorewithscoresResult) {
            System.out.println("element: " + tuple.getElement() + "; score: " + tuple.getScore());
        }

        Long zremResult = jedis.zrem(key, "John");
        System.out.println("zrem 命令: " + zremResult);

        System.out.println("zrem 命令后的 teachers: " + jedis.zrange(key, 0, -1));
        jedis.del(key);
    }
}
