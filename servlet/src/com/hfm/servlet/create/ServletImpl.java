package com.hfm.servlet.create;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 15:41
 * @Description 第一种实现 servlet 的方式实现 servlet 接口
 * @date 2020/8/11
 */
public class ServletImpl implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 接收请求/做出响应的主要方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 设置字符编码
        servletResponse.setContentType("text/html;charset=utf-8");
        // 向浏览器写出
        servletResponse.getWriter().write("实现 servlet 接口方式开发 servlet - 当前时间：" + new Date());

        // 类型转换（因为它有 getMethod() 方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * 做 get 请求的操作
     */
    public void doGet() {
        System.out.println("doget");
    }

    /**
     * 做 post 请求的操作
     */
    public void doPost() {
        System.out.println("doget");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
