package com.hfm.web;

import com.hfm.pojo.User;
import com.hfm.server.UserServer;
import com.hfm.server.impl.UserServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 18:06
 * @Description 登录 Servlet
 * @date 2020/8/16
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 创建 User 业务处理对象
        UserServer userServer = new UserServerImpl();

        User user = new User();
        user.setUsername(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        User login = userServer.login(user);
        // 如果没有值登录失败
        if (login == null) {

        } else {
            // 登录成功，请求转发
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }
    }
}
