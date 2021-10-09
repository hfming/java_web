package com.hfm.http.request.login.daoimpl;

import com.hfm.http.request.login.dao.UserDAO;
import com.hfm.http.request.login.entity.User;

import java.sql.Connection;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 10:19
 * @Description
 * @date 2020/8/15
 */
public class UserDAOImpl extends DAO<User> implements UserDAO {
    @Override
    public User login(Connection connection, String name, String password) {
        String sql = "select username as `name`,password from t_user where username=? and password=?";

        return querySingle(connection, sql, name, password);
    }
}
