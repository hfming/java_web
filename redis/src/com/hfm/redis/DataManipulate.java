package com.hfm.redis;

import com.hfm.util.JedisPoolUtils;
import com.hfm.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 21:32
 * @Description Redis 数据操纵
 * @date 2020/9/7
 */
public class DataManipulate {
    /**
     * 字符串类型
     */
    @Test
    public void stringTest() {
        // 获取 数据库连接对象
        Jedis jedis = JedisUtil.getJedis();

        // 存储 String 数据
        jedis.set("username", "hfm");
        // 获取 String 数据
        System.out.println(jedis.get("username"));

        // 删除 String 数据
        jedis.del("username");

        System.out.println(jedis.get("username"));

        // 存储 20 秒后自动删除的 String 型数据
        jedis.setex("activeTime", 20, "20s");

        // 关闭连接
        JedisUtil.close(jedis);
    }

    /**
     * Hash 类型数据
     */
    @Test
    public void hashMapTest() {
        Jedis jedis = JedisUtil.getJedis();

        HashMap<String, String> map = new HashMap<>();
        map.put("username", "hfm");
        map.put("password", "17111711");

        // 存储 Hash 型数据
        jedis.hset("user", map);

        // 获取指定字段数据
        String username = jedis.hget("user", "username");
        System.out.println(username);
        String password = jedis.hget("user", "password");
        System.out.println(password);

        // 获取所有字段数据
        Map<String, String> user = jedis.hgetAll("user");
        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 删除指定字段数据
        jedis.hdel("user", "username");

        Map<String, String> user2 = jedis.hgetAll("user");
        for (Map.Entry<String, String> entry : user2.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        jedis.hdel("user", "password");

        // 关闭连接
        JedisUtil.close(jedis);
    }

    /**
     * 列表类型
     */
    @Test
    public void listTest() {
        Jedis jedis = JedisUtil.getJedis();

        // 左入队
        jedis.lpush("myList", "a");
        jedis.lpush("myList", "b");

        // 右队
        jedis.rpush("myList", "A");
        jedis.rpush("myList", "B");

        // 查询指定范围的列表
        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);

        // 左出队
        System.out.println(jedis.lpop("myList"));

        // 右出队
        System.out.println(jedis.rpop("myList"));

        List<String> myList2 = jedis.lrange("myList", 0, -1);
        System.out.println(myList2);

        // 关闭连接
        JedisUtil.close(jedis);
    }

    /**
     * 集合型数据
     */
    @Test
    public void setTest() {
        Jedis jedis = JedisUtil.getJedis();

        // 存储 set
        jedis.sadd("mySet", "username");
        jedis.sadd("mySet", "password");

        // 查询 set 型数据
        Set<String> mySet = jedis.smembers("mySet");
        for (String s : mySet) {
            System.out.println(s);
        }

        // 删除 Set 集合中的元素
        jedis.srem("mySet", "username");

        Set<String> mySet2 = jedis.smembers("mySet");
        for (String s : mySet2) {
            System.out.println(s);
        }

        // 关闭连接
        JedisUtil.close(jedis);
    }

    /**
     * 有序集合型数据
     */
    @Test
    public void sortSetTest() {
        Jedis jedis = JedisUtil.getJedis();

        // 存储有序集合型数据
        jedis.zadd("mySortSet", 70, "A");
        jedis.zadd("mySortSet", 60, "B");
        jedis.zadd("mySortSet", 80, "C");

        // 查询有序集合数据,指定范围内的，不带排序数
        Set<String> mySortSet = jedis.zrange("mySortSet", 0, -1);
        for (String s : mySortSet) {
            System.out.println(s);
        }

        // 查询指定范围内的有序集合，带排序数
        Set<Tuple> mySortSet1 = jedis.zrangeWithScores("mySortSet", 0, -1);
        for (Tuple tuple : mySortSet1) {
            System.out.println(tuple);
        }

        // 删除有序集合中的指定元素
        jedis.zrem("mySortSet", "A");

        Set<String> mySortSet2 = jedis.zrange("mySortSet", 0, -1);
        for (String s : mySortSet2) {
            System.out.println(s);
        }
    }

    /**
     * 获取所有键
     */
    @Test
    public void getKeys() {
        Jedis jedis = JedisPoolUtils.getJedis();

        // 获取数据并输出
        Set<String> list = jedis.keys("*");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
