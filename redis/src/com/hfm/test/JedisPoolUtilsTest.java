package com.hfm.test;

import com.hfm.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 12:00
 * @Description
 * @date 2020/9/8
 */
public class JedisPoolUtilsTest {

    @Test
    public void getJedis() {
        Jedis jedis =JedisPoolUtils.getJedis();

        System.out.println(jedis.keys("*"));
    }
}