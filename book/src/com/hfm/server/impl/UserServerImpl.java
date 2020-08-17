package com.hfm.server.impl;

import com.hfm.dao.UserDAO;
import com.hfm.dao.impl.UserDAOImpl;
import com.hfm.pojo.User;
import com.hfm.server.UserServer;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 20:11
 * @Description
 * @date 2020/8/16
 */
public class UserServerImpl implements UserServer {
    /**
     * 创建数库操作对象
     */
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void regist(User user) {
        userDAO.insert(user);
    }

    @Override
    public User login(User user) {
        return userDAO.login(user.getUsername(), user.getPassword());
    }

    /**
     * 如果有数据说明已经有该用户明
     *
     * @param name
     * @return
     */
    @Override
    public boolean checkName(String name) {
        User user = userDAO.QueryByName(name);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }
}
