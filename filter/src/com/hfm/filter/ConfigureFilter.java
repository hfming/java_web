package com.hfm.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 16:32
 * @Description Filter 过滤器参数配置
 * @date 2020/8/29
 */
//@WebFilter(filterName = "ConfigureFilter", urlPatterns = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)// REQUEST：默认值。浏览器直接请求资源时该过滤器会执行
//@WebFilter(filterName = "ConfigureFilter", urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, initParams = {@WebInitParam(name = "aaa", value = "value")})
// 配置多种情况访问资源时过滤器执行
public class ConfigureFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("Filter 过滤配置 - 销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("Filter 过滤配置 - 执行前");
        // FilterChain 就是过滤器链对象，doFilter 方法把请求交给下一个过滤器，如果没有就访问到目标资源
        chain.doFilter(req, resp);
        System.out.println("Filter 过滤配置 - 执行后");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter 过滤配置 - 初始化");
        // 获取Filter 名称
        System.out.println(config.getFilterName());

        // FilterConfig 对象封装了当前过滤器配置的 init-param 初始化参数
        String param = config.getInitParameter("aaa");
        System.out.println(param);

        // 获取 ServletContext 对象
        System.out.println(config.getServletContext());
    }
}
