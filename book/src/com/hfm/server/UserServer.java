package com.hfm.server;

import com.hfm.pojo.User;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 20:09
 * @Description
 * @date 2020/8/16
 */
public interface UserServer {
    /**
     * 注册
     * @param user
     */
    void regist(User user);
    /**
     * 登录
     * @param user
     */
    User login(User user);

    /**
     * 用户名是否可用
     * @param name
     */
    boolean checkName(String name);
}
