package com.hfm.demo;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 17:37
 * @Description 登录过滤器
 * @date 2020/8/29
 */
//@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("登录过滤器 - 销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 转换成 HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 判断是否是登录相关的资源
        String uri = request.getRequestURI();
        // css/js/图片/验证码 等资源也需要排除
        if (uri.contains("/login.jsp") || uri.contains("/login") || uri.contains("css") || uri.contains("js") || uri.contains("fonts") || uri.contains("/checkCode")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
//            User user = (User) session.getAttribute("user");
//            // 判断用户是否已经登录
//            if (user == null) {
//                // 如果没有登录，重定向到登录页面
//                response.sendRedirect(request.getContextPath() + "/login.jsp");
//            } else {
//                chain.doFilter(req, resp);
//            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("登录过滤器 - 启动");
    }
}
