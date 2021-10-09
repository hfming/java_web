package com.hfm.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 15:41
 * @Description 注解式开发过滤器
 * @date 2020/8/29
 */
//@WebFilter(filterName = "FirstFilter",urlPatterns="/*") // 访问所有资源前都会执行过滤器
public class FirstFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("Filter 过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 放行
        chain.doFilter(req, resp);
        System.out.println("注解式开发");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter 过滤器初始化");
    }
}
