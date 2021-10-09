package com.hfm.servlet;

import com.hfm.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-20 17:48
 * @Description
 * @date 2020/8/20
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

        // 模拟使用 DAOImpl 查询数据库
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "hfm", "17111711"));
        users.add(new User("2", "pdd", "12345667"));
        users.add(new User("3", "tff", "12362324"));
        users.add(new User("4", "ymm", "87545342"));

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        for (User user : users) {
            // 如果找到用户名与密码都匹配的进行请求转发
            if (name.equalsIgnoreCase(user.getName()) && password.equalsIgnoreCase(user.getPassword())) {
                request.setAttribute("name", name);
                // 注意转发不需要 web 上下文路径
                request.getRequestDispatcher("/users").forward(request, response);
            }
        }
        request.setAttribute("mes", "用户名或密码错误");
        // 如果没有找到,重新返回登录页面
        request.getRequestDispatcher("/jstl/login.jsp").forward(request, response);
    }
}
