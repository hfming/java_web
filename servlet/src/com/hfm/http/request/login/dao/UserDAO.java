package com.hfm.http.request.login.dao;

import com.hfm.http.request.login.entity.User;

import java.sql.Connection;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 10:18
 * @Description
 * @date 2020/8/15
 */
public interface UserDAO {
    User login(Connection connection,String name, String password);
}
