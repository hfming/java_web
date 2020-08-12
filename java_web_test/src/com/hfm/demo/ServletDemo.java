package com.hfm.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletDemo")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        System.out.println("接收数据");
        // 根据前端标签的name 属性获取参数
        String username = request.getParameter("username");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String hobit = request.getParameter("hobit");
        String id = request.getParameter("id");
        String city = request.getParameter("id");

        System.out.println(username);
        System.out.println(userPassword);
        System.out.println(gender);
        System.out.println(hobit);
        System.out.println(id);
        System.out.println(city);
    }
}
