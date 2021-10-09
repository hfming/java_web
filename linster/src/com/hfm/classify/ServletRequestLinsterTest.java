package com.hfm.classify;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 18:39
 * @Description
 * @date 2020/8/30
 */
//@WebListener
public class ServletRequestLinsterTest implements ServletRequestListener {
    /**
     * 请求销毁，完成请求后请求对象销毁
     *
     * @param servletRequestEvent
     */
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest 请求监听器 - 销毁");

        // 获取 httpServletRequest 对象
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();

        // 获取请求的参数
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);
    }

    /**
     * 请求创建，每次请求时创建
     *
     * @param servletRequestEvent
     */
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest 请求监听器 - 创建");
    }
}
