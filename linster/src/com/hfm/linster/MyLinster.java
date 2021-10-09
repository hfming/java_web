package com.hfm.linster;

import com.hfm.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 21:44
 * @Description
 * @date 2020/8/29
 */
public class MyLinster implements ServletContextListener {
    /**
     * 监听 ServletContext 对象创建，ServletContext 对象在服务器启动后自动创建
     * ServletContext 对象创建后自动调用 监听器的contextInitialized 方法
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Session 监听器 - Session 对象创建");
        // 获取到 ServletContext 对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        // 存储登录的 user 用户列表
        ArrayList<User> users = new ArrayList<>();
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            // 如果获取到登录用户列表则进行赋值
            if ("users".equalsIgnoreCase(s)) {
                users = (ArrayList<User>) servletContext.getAttribute(s);
            }
        }
        users.add(new User("hfm", "17111711", "100000", "120000", "127.0.0.1"));

        // 将新用户列表放入 ServletContext 域中
        servletContext.setAttribute("users", users);
    }

    /**
     * 在服务器关闭后，ServletContext 对象销毁，当服务器正常关闭后自动调用 contextDestroyed 方法
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 销毁");
    }
}
