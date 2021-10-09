package com.hfm.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 23:28
 * @Description
 * @date 2020/9/7
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        try {
            //读取配置文件
            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            //创建Properties对象
            Properties pro = new Properties();
            //关联文件
            pro.load(is);

            //获取数据，设置到JedisPoolConfig中
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(ParamsUtils.parseInt(pro.getProperty("maxTotal"), 50));
            config.setMaxIdle(ParamsUtils.parseInt(pro.getProperty("maxIdle"), 10));

            //初始化JedisPool
            jedisPool = new JedisPool(config, pro.getProperty("host"), ParamsUtils.parseInt(pro.getProperty("port"), 6379),300000,"tiger2018");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭 Redis 数据库连接，并还给数据库连接池
     *
     * @param jedis
     */
    public static void close(Jedis jedis) {
        jedis.close();
    }
}
