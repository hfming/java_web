package com.hfm.classify;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 16:11
 * @Description ServletContext 属性监听器
 * @date 2020/8/30
 */
//@WebListener
public class ServletContextAttributeListenerTest implements ServletContextAttributeListener {
    /**
     * 添加属性
     *
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext 属性添加了");

        // 获取属性值
        String name = servletContextAttributeEvent.getName();
        // 获取属性值
        Object value = servletContextAttributeEvent.getValue();
        // 获取属性源
        Object source = servletContextAttributeEvent.getSource();
        // 获取事件源
        ServletContext servletContext = servletContextAttributeEvent.getServletContext();
    }

    /**
     * 删除属性
     *
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext 属性删除了");
    }

    /**
     * 修改属性
     *
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext 属性修改了");

        // 获取修改后的属性值，需要调用两次获取属性值的方法
        // 获取事件源
        ServletContext servletContext = servletContextAttributeEvent.getServletContext();
        // 获取修改后的属性值
        Object name = servletContext.getAttribute("name");
    }
}
