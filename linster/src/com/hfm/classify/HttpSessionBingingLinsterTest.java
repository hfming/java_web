package com.hfm.classify;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 19:10
 * @Description
 * @date 2020/8/30
 */
public class HttpSessionBingingLinsterTest implements HttpSessionBindingListener {
    /**
     * 添加属性
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 添加属性");
    }

    /**
     * 删除属性
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("删除属性");
    }
}
