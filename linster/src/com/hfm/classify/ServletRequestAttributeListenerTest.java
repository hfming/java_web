package com.hfm.classify;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 18:50
 * @Description
 * @date 2020/8/30
 */
public class ServletRequestAttributeListenerTest implements ServletRequestAttributeListener {
    /**
     * 属性添加
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request 属性添加");
    }

    /**
     * 属性删除
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request 属性删除");
    }

    /**
     * 属性修改
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request 属性修改");
    }
}
