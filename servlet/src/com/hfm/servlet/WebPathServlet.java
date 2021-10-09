package com.hfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 20:01
 * @Description 资源路径问题
 * @date 2020/8/13
 */
@WebServlet(name = "WebPathServlet", urlPatterns = "/webPath")
public class WebPathServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 请求转发是服务器行为，只能访问当前web 应用的资源 /代表当前项目的根目录
        // 请求重定向，超链接，表单提交 都是浏览器行为，可以访问 tomcat 中其他应用的资源，因此需要添加项目名，/ 代表当前站点的根路径

        // 请求转发的路径
        //request.getRequestDispatcher("/static/html/FormTest.html").forward(request,response);

        // 重定向路径
        //response.sendRedirect("/servlet/static/html/FormTest.html");

        // 超链接路径
        response.getWriter().write("<a href='/servlet/static/html/FormTest.html'>超链接</a>");

        // 表单路径
        response.getWriter().write("<form action=\"/servlet/static/html/FormTest.html\" method=\"get\">\n" +
                "\t\t\t\t<input type=\"submit\" value=\"Get 方式提交\" />\n" +
                "\t\t\t</form>");
    }
}
