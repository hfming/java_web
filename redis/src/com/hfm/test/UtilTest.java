package com.hfm.test;

import com.hfm.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 10:29
 * @Description
 * @date 2020/9/8
 */
public class UtilTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();

        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println(key);
        }
    }
}
