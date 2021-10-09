package com.hfm.classify;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 18:53
 * @Description
 * @date 2020/8/30
 */
//@WebListener
public class HttpSessionLinsterTest implements HttpSessionListener {
    /**
     * session 对象创建
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session 对象创建");
    }

    /**
     * session 对象销毁
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // 默认 30 分钟销毁
        System.out.println("Session 对象销毁");
    }
}
