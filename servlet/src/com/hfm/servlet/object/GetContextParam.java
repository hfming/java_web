package com.hfm.servlet.object;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 16:24
 * @Description ServletContext 获取全局参数
 * @date 2020/8/13
 */
@WebServlet(name = "GetContextParam", urlPatterns = "/contextParam")
public class GetContextParam extends HttpServlet {
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

        // 获取全局参数的名称集合
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        // 迭代获取全部的全局参数
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            // 根据指定参数名获取全局参数
            String initParameter = servletContext.getInitParameter(name);

            System.out.println(name + ":" + initParameter);
        }

        // 根据指定参数名获取全局参数
        String myParam = servletContext.getInitParameter("myParam");
        System.out.println("myParam:" + myParam);
    }
}
