package com.hfm.http.request.login.web;

import com.hfm.http.request.login.daoimpl.UserDAOImpl;
import com.hfm.http.request.login.entity.User;
import com.hfm.http.request.login.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 10:26
 * @Description
 * @date 2020/8/15
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取表单输入
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // 创建User 数据库操作对象
        UserDAOImpl userDAO = new UserDAOImpl();

        // 创建连接
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnectionByDruid();
            User login = userDAO.login(connection, name, password);
            if (login == null) {
                response.getWriter().write("登录失败");
            } else {
                response.getWriter().write("成功");
                response.setHeader("refresh", "5;/servlet/beanUtil?name=" + name + "&password=" + password);
            }
        } finally {
            JDBCUtils.closeResources(connection, null);
        }
    }
}
