package com.hfm.pojo;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 20:48
 * @Description
 * @date 2020/8/30
 */
public class User {
    private String name;
    private String password;
    private String liginTime;
    private String lastLoginTime;
    private String IP;

    public User() {
    }

    public User(String name, String password, String liginTime, String lastLoginTime, String IP) {
        this.name = name;
        this.password = password;
        this.liginTime = liginTime;
        this.lastLoginTime = lastLoginTime;
        this.IP = IP;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", liginTime='").append(liginTime).append('\'');
        sb.append(", lastLoginTime='").append(lastLoginTime).append('\'');
        sb.append(", IP='").append(IP).append('\'');
        sb.append('}');
        return sb.toString();
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
                Objects.equals(password, user.password) &&
                Objects.equals(liginTime, user.liginTime) &&
                Objects.equals(lastLoginTime, user.lastLoginTime) &&
                Objects.equals(IP, user.IP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, liginTime, lastLoginTime, IP);
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

    public String getLiginTime() {
        return liginTime;
    }

    public void setLiginTime(String liginTime) {
        this.liginTime = liginTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
