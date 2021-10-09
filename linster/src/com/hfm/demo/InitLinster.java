package com.hfm.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 21:56
 * @Description 加载初始化资源文件
 * @date 2020/8/29
 */
//@WebListener(value = "InitLinster")
public class InitLinster implements ServletContextListener {
    /**
     * 监听 ServletContext 对象创建，ServletContext 对象在服务器启动后自动创建
     * ServletContext 对象创建后自动调用 监听器的contextInitialized 方法
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("自定义 Linster 监听器 - 启动 - ServletContext 创建");

        BufferedReader bufferedReader = null;
        try {
            // 加载资源
            // 读取 web.xml 文件中的初始化配置块 <context-param>
            ServletContext servletContext = servletContextEvent.getServletContext();
            // 获取全局参数
            String initParameter = servletContext.getInitParameter("fileSrc");

            // 获取真实路径
            String realPath = servletContext.getRealPath(initParameter);
            // 创建流
            bufferedReader = new BufferedReader(new FileReader(realPath));

            String content ;
            // 读取文件
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在服务器关闭后，ServletContext 对象销毁，当服务器正常关闭后自动调用 contextDestroyed 方法
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("自定义 Linster 监听器 - 关闭 - ServletContext 销毁");
    }
}
