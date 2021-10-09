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
 * @version 1.01 2020-08-13 16:50
 * @Description ServletContext setAttribute 保存域对象
 * @date 2020/8/13
 */
@WebServlet(name = "SetAttributeServlet",urlPatterns = "/setAttribute")
public class SetAttributeServlet extends HttpServlet {
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

        String contextPath = servletContext.getContextPath();
        // 重定向跳转到 getAttribute
        response.sendRedirect(contextPath+"/getAttribute");
    }
}
