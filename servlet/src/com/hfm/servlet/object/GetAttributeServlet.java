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
 * @version 1.01 2020-08-13 16:51
 * @Description ServletContext getAttribute 获取域对象
 * @date 2020/8/13
 */
@WebServlet(name = "GetAttributeServlet", urlPatterns = "/getAttribute")
public class GetAttributeServlet extends HttpServlet {
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

        // 根据指定 Attribute 域对象名获取属性值
        String myParam = (String) servletContext.getAttribute("myParam");
        System.out.println(myParam);
        int count = (int) servletContext.getAttribute("count");
        System.out.println(count);

        // 获取 Attribute 域对象名的集合
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        // 遍历获取所有的域对象的值
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attribute = servletContext.getAttribute(attributeName);
            System.out.println(attributeName + ":" + attribute);
        }
    }
}
