package com.hfm.servlet.object;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 12:09
 * @Description
 * @date 2020/8/13
 */
public class ServletConfigTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取 ServletConfig 对象
        ServletConfig servletConfig = this.getServletConfig();

        // 获取 servlet 名称
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

        // 获取 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();

        // 获取初始化参数名集合
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        // 遍历集合，取出所有初始化参数
        while (initParameterNames.hasMoreElements()) {
            System.out.println( servletConfig.getInitParameter(initParameterNames.nextElement()));
        }

        // 获取指定的初始化参数
        String path = servletConfig.getInitParameter("path");
        System.out.println(path);
    }
}
