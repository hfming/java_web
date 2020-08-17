package com.hfm.dao;

import com.hfm.pojo.User;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 17:05
 * @Description
 * @date 2020/8/16
 */
public interface UserDAO {
    /**
     * 添加 User 对象
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据指定的ID 删除 User
     *
     * @param id
     */
    void deleteByID(int id);

    /**
     * 修改 User
     *
     * @param user
     */
    void updateByID(User user);

    /**
     * 根据 ID 查找 User
     *
     * @param id
     * @return
     */
    User getUserByID(int id);

    /**
     * 查询所有 User
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询 User 数目
     *
     * @return
     */
    Long getCount();

    /**
     * 使用账号与密码登录
     *
     * @param userName
     * @param passwrod
     * @return
     */
    User login(String userName, String passwrod);

    /**
     * 通过用户名返回用户信息
     *
     * @param name
     * @return
     */
    User QueryByName(String name);
}
