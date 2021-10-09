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
 * @version 1.01 2020-08-19 14:36
 * @Description
 * @date 2020/8/19
 */
@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 模拟使用 DAOImpl 类进行数据库查询将查询到的数据转发到动态页面
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "hfm", "17111711"));
        users.add(new User("2", "pdd", "12345667"));
        users.add(new User("3", "tff", "12362324"));
        users.add(new User("4", "ymm", "87545342"));

        // 通过域对象进行转发
        request.setAttribute("users", users);
//        request.getRequestDispatcher("/jsp/users.jsp").forward(request,response);
        request.getRequestDispatcher("/jstl/users.jsp").forward(request, response);
    }
}
