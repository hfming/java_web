package com.hfm.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 10:54
 * @Description 字符编码过滤器
 * @date 2020/8/30
 */
//@WebFilter(filterName = "CharsetFilter", urlPatterns = "/*")
public class CharsetFilter implements Filter {
    /**
     * 构造函数
     */
    public CharsetFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符编码过滤器 - 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("字符编码过滤器 - 执行前");
        // 数据类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 通过装饰者设计模式增强 request 的 getParamenter 方法
        // 不能使用匿名类，因为需要构造函数
        MyRequest myRequest = new MyRequest(request);

        // 放行
        filterChain.doFilter(myRequest, response);
        System.out.println("字符编码过滤器 - 执行后");
    }

    @Override
    public void destroy() {
        System.out.println("字符编码过滤器 - 销毁");
    }
}
