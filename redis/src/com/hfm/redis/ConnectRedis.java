package com.hfm.redis;

import redis.clients.jedis.Jedis;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 21:10
 * @Description
 * @date 2020/9/7
 */
public class ConnectRedis {
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        // ip 地址
        // 端口号
        Jedis jedis = new Jedis("47.99.213.57",6379);
        // 密码
        jedis.auth("tiger2018");

        System.out.println("成功连接 Redis 数据库");
        // 查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

        // 存储 String 元素
        jedis.set("username", "hfm");

        // 获取 String 数据
        String username = jedis.get("username");
        System.out.println(username);

        // 删除 String 元素
        jedis.del("username");
        String username2 = jedis.get("username");
        System.out.println(username2);

        // 关闭连接
        jedis.close();
    }
}