package com.hfm.demo.server.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfm.demo.DAO.ProvinceDAO;
import com.hfm.demo.DAO.impl.ProvinceDAOimpl;
import com.hfm.demo.pojo.Province;
import com.hfm.demo.server.ProvinceServer;
import com.hfm.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:07
 * @Description
 * @date 2020/9/8
 */
public class ProvinceServerImpl implements ProvinceServer {
    private ProvinceDAO provinceDAO = new ProvinceDAOimpl();

    @Override
    public List<Province> provinces() {
        return provinceDAO.provinces();
    }

    /**
     * 使用 redis缓存
     *
     * @return
     */
    @Override
    public String provincesJsonFormRedis() {
        // 获取数据库连接池对象
        Jedis jedis = JedisPoolUtils.getJedis();
        try {
            String provinces = jedis.get("provinces");
            if (provinces == null || "".equalsIgnoreCase(provinces.trim())) {
                // 如果没有从数据库中查找
                List<Province> provincesList = provinceDAO.provinces();

                // JSON 序列化
                ObjectMapper objectMapper = new ObjectMapper();

                provinces = objectMapper.writeValueAsString(provincesList);
            }
            // 将 JSON 数据保存到 redis 数据库
            jedis.set("provinces", provinces);
            return provinces;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            jedis.close();
        }
    }
}
