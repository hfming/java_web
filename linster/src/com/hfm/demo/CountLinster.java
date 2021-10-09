package com.hfm.demo;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 19:22
 * @Description 统计在线人数
 * @date 2020/8/30
 */
@WebListener
public class CountLinster implements HttpSessionListener {
    /**
     * 多线程可能有线程安全问题，使用原子整数，无锁并发方式解决线程安全问题
     */
    private static AtomicInteger count = new AtomicInteger();

    /**
     * 用户第一次访问资源时创建 Session 对象
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session 监听器 - Session 对象创建");
        // 获取到 ServletContext 对象
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        // 获取到 ServletContext 域中保存的值
        // 如果没有对应的属性会抛出异常
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            // 如果找到 count 属性就获取,如果没有则初始值为 0
            if ("count".equalsIgnoreCase(s)) {
                // 无锁并发，解决线程安全问题
                while (count.compareAndSet(count.intValue(), (Integer) servletContext.getAttribute("count"))) {
                    break;
                }
            }
        }

        // 将新值放入域中
        servletContext.setAttribute("count", count.getAndIncrement());
    }

    /**
     * 默认 30 分钟删除 Session 对象
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session 监听器 - Session 对象销毁");
        // 获取到 ServletContext 对象
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        // 获取到 ServletContext 域中保存的值
//        int count = (int) servletContext.getAttribute("count");
//        System.out.println(count);

        // 将新值放入域中
        servletContext.setAttribute("count", count.getAndDecrement());
    }
}
