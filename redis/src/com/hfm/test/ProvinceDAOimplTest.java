package com.hfm.test;

import com.hfm.demo.DAO.impl.ProvinceDAOimpl;
import com.hfm.demo.pojo.Province;
import org.junit.Test;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:09
 * @Description
 * @date 2020/9/8
 */
public class ProvinceDAOimplTest {

    @Test
    public void provinces() {
        ProvinceDAOimpl provinceDAOimpl = new ProvinceDAOimpl();

        List<Province> provinces = provinceDAOimpl.provinces();
        System.out.println(provinces);
    }
}