package com.hfm.demo.server;

import com.hfm.demo.pojo.Province;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:03
 * @Description
 * @date 2020/9/8
 */
public interface ProvinceServer {
    List<Province> provinces();

    String provincesJsonFormRedis();
}
