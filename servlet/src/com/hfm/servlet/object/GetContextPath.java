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
 * @version 1.01 2020-08-13 16:21
 * @Description ServletConttext 获取 web 上下文路径
 * @date 2020/8/13
 */
@WebServlet(name = "GetContextPath",urlPatterns = "/contextPath")
public class GetContextPath extends HttpServlet {
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
        // true
        System.out.println(servletContext == servletContext1);

        // 获取 web 上下文路径 /servlet 就是获取项目名
        // 相对路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        // 绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
    }
}
