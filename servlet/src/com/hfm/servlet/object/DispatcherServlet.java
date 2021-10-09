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
 * @version 1.01 2020-08-13 17:32
 * @Description 请求转发
 * @date 2020/8/13
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = "/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 获取 ServletContext 对象
        ServletContext servletContext = this.getServletContext();

        // 设置 Attribute 域对象
        // 键值对方式，键是 String 数据类型，值可以是任意数据类型
        servletContext.setAttribute("myParam", "Test");
        servletContext.setAttribute("count", 2);

//        // 获取 RequestDispatcher 对象用于请求转发,只能访问当前项目的资源
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getAttribute");
//
//        // 调用 RequestDispatcher forward 方法转发请求
//        requestDispatcher.forward(request, response);

        // 请求转化简写
        request.getRequestDispatcher("/getAttribute").forward(request,response);
    }
}
