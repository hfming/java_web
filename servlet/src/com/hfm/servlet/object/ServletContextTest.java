package com.hfm.servlet.object;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 12:31
 * @Description
 * @date 2020/8/13
 */
@WebServlet(name = "ServletContextTest", urlPatterns = "/servletContext")
public class ServletContextTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 获取 ServletContext 对象
        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        // 简化方法，内部调用 ServletContext.getServletContext() 方法
        ServletContext servletContext = this.getServletContext();

        ServletContext servletContext2 = request.getServletContext();

        // true
        System.out.println(servletContext == servletContext1);
        // true
        System.out.println(servletContext == servletContext2);
        // true
        System.out.println(servletContext2 == servletContext1);

        // 获取 web 上下文路径 /servlet 就是获取项目名
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

        // 请求重定向
        response.sendRedirect(contextPath + "/servletConfigTest");
    }
}
