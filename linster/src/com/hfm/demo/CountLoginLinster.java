package com.hfm.demo;

import com.hfm.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 20:10
 * @Description 统计登录人数
 * @date 2020/8/30
 */
//@WebListener
public class CountLoginLinster implements HttpSessionAttributeListener {
    /**
     * 监听 Session 的属性，如果 添加了 user 属性就触发
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        // 获取到 ServletContext 对象
        ServletContext servletContext = httpSessionBindingEvent.getSession().getServletContext();

        int loginCount = 0;
        // 存储登录的 user 用户列表
        ArrayList<User> users = new ArrayList<>();
        // 获取到 ServletContext 域中保存的值
        // 如果没有对应的属性会抛出异常
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            // 如果找到 count 属性就获取,如果没有则初始值为 0
            if ("loginCount".equalsIgnoreCase(s)) {
                loginCount = (int) servletContext.getAttribute("loginCount");
            }
            // 如果获取到登录用户列表则进行赋值
            if ("users".equalsIgnoreCase(s)) {
                users = (ArrayList<User>) servletContext.getAttribute(s);
            }
        }

        HttpSession session = httpSessionBindingEvent.getSession();
        Enumeration<String> names = session.getAttributeNames();

        while (names.hasMoreElements()) {
            String s = names.nextElement();
            // 如果找到 user 属性，登录用户数目 +1
            if ("user".equalsIgnoreCase(s)) {
                // 获取的用户中已经有 用户名、密码、用户 IP 地址
                User user = (User) session.getAttribute(s);

                // 设置上次访问时间
                user.setLastLoginTime(session.getLastAccessedTime() + "");
                // 设置登录时间
                user.setLiginTime(session.getCreationTime() + "");

                // 将用户放入 users 列表中
                users.add(user);

                // 将新用户列表放入 ServletContext 域中
                servletContext.setAttribute("users", users);

                // 将登录用户数新值放入域中
                servletContext.setAttribute("loginCount", loginCount + 1);
            }
        }
    }

    /**
     * 删除 session 中的 user 属性时删除用户列表中的 user
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        // 获取到 ServletContext 对象
        ServletContext servletContext = httpSessionBindingEvent.getSession().getServletContext();

        // 获取 session 对象
        HttpSession session = httpSessionBindingEvent.getSession();

        ArrayList<User> users = (ArrayList<User>) servletContext.getAttribute("users");
        // 从登录用户集合中，删除 user 对象
        User rmUser = (User) session.getAttribute("user");
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(rmUser.getName())) {
                users.remove(user);
            }
        }

        // 将新的用户集合添加到 servletContext 域中
        servletContext.setAttribute("users", users);

        // 获取到 ServletContext 域中保存的值
        int loginCount = (int) servletContext.getAttribute("loginCount");
        // 将登录用户新值放入域中
        servletContext.setAttribute("loginCount", loginCount - 1);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
