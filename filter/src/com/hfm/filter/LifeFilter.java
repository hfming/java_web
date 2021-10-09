package com.hfm.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 16:16
 * @Description Filter 过滤器生命周期
 * @date 2020/8/29
 */
//@WebFilter(filterName = "LifeFilter", urlPatterns = "/*")
public class LifeFilter implements Filter {
    /**
     * 构造函数
     */
    public LifeFilter() {
        System.out.println("Filter 生命周期 - Filter 构造函数");
    }

    /**
     * 服务器关闭后，Filter 对象被回收，如果服务器正常关闭，则会执行 destory 方法，只执行一次
     * 一般用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("Filter 生命周期 - 销毁");
    }

    /**
     * 每一次请求被拦截资源时执行，可以执行多次
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("Filter 生命周期 - 过滤前");
        chain.doFilter(req, resp);
        System.out.println("Filter 生命周期 - 过滤后");
    }

    /**
     * 在服务器启动后，创建 Filter 对象，然后调用 init方法，只执行一次
     * 一般用于加载资源
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter 生命周期 - 初始化");
    }
}
