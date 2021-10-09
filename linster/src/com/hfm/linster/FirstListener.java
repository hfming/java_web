package com.hfm.linster;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 21:40
 * @Description
 * @date 2020/8/29
 */
//@WebListener()
public class FirstListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public FirstListener() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 在初始化servlet上下文时(部署Web应用程序时)调用此方法。您可以在这里初始化servlet上下文相关的数据。
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 当未部署Servlet上下文(Web应用程序)或应用程序服务器关闭时，将调用此方法。
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 创建 session 会话。
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        // 将属性添加到会话时调用此方法。
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        // 当从会话中删除属性时调用此方法。
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        // 在会话中替换属性时调用此方法。
    }
}
