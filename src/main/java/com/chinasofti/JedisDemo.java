package com.chinasofti;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo {
    public static void main(String[] args) {
//        Jedis jedis=new Jedis("127.0.0.1",6379);
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        Jedis jedis=jedisPool.getResource();
        jedis.set("test","hello");
       jedis.close();
    }
}
