package com.hfm.test;

import com.hfm.demo.pojo.Province;
import com.hfm.demo.server.impl.ProvinceServerImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:49
 * @Description
 * @date 2020/9/8
 */
public class ProvinceServerImplTest {
    @Test
    public void provinces(){
        long l = System.currentTimeMillis();
        ProvinceServerImpl provinceServer = new ProvinceServerImpl();

        for (int i = 0; i < 1000; i++) {
            List<Province> provinces = provinceServer.provinces();
            System.out.println(provinces);
        }
        // 20784
        System.out.println(System.currentTimeMillis()-l);
    }

    @Test
    public void provincesJsonFormRedis() {
        long l = System.currentTimeMillis();
        ProvinceServerImpl provinceServer = new ProvinceServerImpl();

        for (int i = 0; i < 1000; i++) {
            String s = provinceServer.provincesJsonFormRedis();

            System.out.println(s);
        }
        // 47004
        System.out.println(System.currentTimeMillis()-l);
    }
}