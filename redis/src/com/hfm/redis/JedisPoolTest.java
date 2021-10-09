package com.hfm.redis;

import com.hfm.util.ParamsUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 22:32
 * @Description
 * @date 2020/9/7
 */
public class JedisPoolTest {
    public static void main(String[] args) throws IOException {
        // 1.创建数据库连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 将配置文件中的数据加载到 jedisPoolConfig 对象中
        InputStream resourceAsStream = JedisPoolTest.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        // 加载配置文件
        properties.load(resourceAsStream);

        String maxTotalStr = (String) properties.get("maxTotal");
        int maxTotal = ParamsUtils.parseInt(maxTotalStr, 50);

        String maxIdleStr = (String) properties.get("maxIdle");
        int maxIdle = ParamsUtils.parseInt(maxIdleStr, 50);

        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);

        String host = (String) properties.get("host");
        String portStr = (String) properties.get("port");
        int port = ParamsUtils.parseInt(portStr, 6379);

        // 2.使用 jedisPoolConfig 创建数据库连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,30000,"tiger2018");

        // 3.从数据库连接池中获取数据库连接
        Jedis resource = jedisPool.getResource();

        // 4.拿获取到的连接进行对应操作
        resource.set("ip", "127.0.0.1");

        System.out.println(resource.get("ip"));

        resource.del("ip");

        // 5. 关闭 归还到连接池中
        resource.close();
    }
}
