package com.hfm.classify;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 15:57
 * @Description ServletContextListener 监听器
 * 1.项目加载时创建表
 * 2.项目删除时将表删除
 * @date 2020/8/30
 */
//@WebListener
public class ServletContextLinsterTest implements ServletContextListener {
    //        userDaoImpl userDao = new userDaoImpl();

    /**
     * 用于监听 servletContext 对象的创建行为
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextLinster 监听器 - ServletContext 对象创建");
//        userDao.createTable();
    }

    /**
     * 用于监听 ServletContext 对象的销毁行为
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextLinster 监听器 - ServletContext 对象销毁");
        //        userDao.dropTable();
    }
}
