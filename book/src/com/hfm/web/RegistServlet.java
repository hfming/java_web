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
 * @version 1.01 2020-08-16 18:07
 * @Description 注册 Servlet
 * @date 2020/8/16
 */
@WebServlet(name = "RegistServlet", urlPatterns = "/regist")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserServer userServer = new UserServerImpl();

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));

        String code = (String) this.getServletContext().getAttribute("code");
        if (request.getParameter("code").equals(code)) {
            // 用户名可用并且成功注册
            if (userServer.checkName(user.getUsername())) {
                userServer.regist(user);
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            } else {
                System.out.println("用户名已存在");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }
        }else {
            System.out.println("验证码错误");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }
}
