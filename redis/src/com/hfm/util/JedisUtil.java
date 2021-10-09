package com.hfm.util;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 21:19
 * @Description 不是最终的 Jedis 工具类
 * @date 2020/9/7
 */
public class JedisUtil {
    /**
     * 获取 Redis 数据库连接对象
     * @return
     */
    public static Jedis getJedis() {
        Jedis jedis = null;
        try {
            ClassLoader classLoader = JedisUtil.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jedis.properties");

            Properties properties = new Properties();
            // 加载配置文件
            properties.load(resourceAsStream);

            String host = (String) properties.get("host");
            String portStr = (String) properties.get("port");
            int port = ParamsUtils.parseInt(portStr, 6379);

            String maxTotalStr = (String) properties.get("maxTotal");

            String maxIdleStr = (String) properties.get("maxIdle");
            jedis = new Jedis(host, port);
            jedis.auth("tiger2018");

            return jedis;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭 Redis 数据库连接
     * @param jedis
     */
    public static void close(Jedis jedis) {
        jedis.close();
    }
}
