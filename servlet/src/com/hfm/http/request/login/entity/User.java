package com.hfm.http.request.login.entity;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 9:39
 * @Description 实体类
 * @date 2020/8/15
 */
public class User {
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    /**
     * 无参构造函数
     */
    public User() {
    }

    /**
     * 全参构造函数
     * @param name
     * @param password
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
