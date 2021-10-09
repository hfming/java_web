package com.hfm.demo.DAO.impl;

import com.hfm.demo.DAO.BaseDAO;
import com.hfm.demo.DAO.ProvinceDAO;
import com.hfm.demo.pojo.Province;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:03
 * @Description
 * @date 2020/9/8
 */
public class ProvinceDAOimpl extends BaseDAO<Province> implements ProvinceDAO {
    @Override
    public List<Province> provinces() {
        String sql = "select * from province";
        return queryTable(sql);
    }
}
