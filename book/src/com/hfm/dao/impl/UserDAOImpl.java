package com.hfm.dao.impl;

import com.hfm.dao.DAO;
import com.hfm.dao.UserDAO;
import com.hfm.pojo.User;
import com.hfm.util.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 17:41
 * @Description
 * @date 2020/8/16
 */
public class UserDAOImpl extends DAO<User> implements UserDAO {
    private Connection connection = null;

    @Override
    public void insert(User user) {
        // 获取连接
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "insert into t_user(username,password,email) VALUES(?,?,?)";
        // Sql 查询
        change(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
        // 关闭连接
        JDBCUtils.closeResources(connection, null);
    }

    @Override
    public void deleteByID(int id) {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "delete from t_user where id =?";
        change(connection, sql, id);
        JDBCUtils.closeResources(connection, null);
    }

    @Override
    public void updateByID(User user) {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "update t_user SET username =?,email=?,password =? where id =?";
        change(connection, sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getId());
        JDBCUtils.closeResources(connection, null);
    }

    @Override
    public User getUserByID(int id) {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "select id,username,email,password from t_user where id =?";
        User user = querySingle(User.class, connection, sql, id);
        JDBCUtils.closeResources(connection, null);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "select id,username,email,password from t_user";
        List<User> users = queryTable(User.class, connection, sql);
        JDBCUtils.closeResources(connection, null);
        return users;
    }

    @Override
    public Long getCount() {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "Select count(1) from t_user";
        Long value = (Long) getValue(connection, sql);
        JDBCUtils.closeResources(connection, null);
        return value;
    }

    @Override
    public User login(String userName, String passwrod) {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        User user = querySingle(User.class, connection, sql, userName, passwrod);
        JDBCUtils.closeResources(connection, null);
        return user;
    }

    @Override
    public User QueryByName(String userName) {
        connection = JDBCUtils.getConnectionByDruid();
        String sql = "select id,username,password,email from t_user where username=?";
        User user = querySingle(User.class, connection, sql, userName);
        JDBCUtils.closeResources(connection, null);
        return user;
    }
}
