package com.hfm.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 15:33
 * @Description 实现 Filter 接口方式开发 Filter 过滤器
 * @date 2020/8/29
 */
public class HelloFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器 - 初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器 - 过滤方法");
        // 只能获取ServletContext 参数,不能获取Servlet参数，因为 Filter 早于 Servlet之前创建，因此ServletConfig 对象不能够获取到
        ServletContext servletContext = servletRequest.getServletContext();
        System.out.println(servletContext.getInitParameter("AAA"));

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器 -  销毁方法");
    }
}
