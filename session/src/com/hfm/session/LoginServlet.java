package com.hfm.session;

import com.hfm.contact.dao.impl.UserDaoImpl;
import com.hfm.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-18 0:00
 * @Description session 登录案例
 * @date 2020/8/18
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

        // 接收参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDaoImpl userDao = new UserDaoImpl();

        User byName = userDao.findByName(name);
        if (byName == null) {
            response.getWriter().write("该用户不存在");
        } else {
            if (password.equalsIgnoreCase(byName.getPassword())) {
                response.getWriter().write("登录成功");

                // 设置 session
                HttpSession session = request.getSession();
                session.setAttribute("name", byName.getName());

                // 重定向
                response.sendRedirect("/session/getAttribute");

                // 注销
                // session.removeAttribute("name");
            } else {
                response.getWriter().write("密码错误！");
            }
        }
    }
}
