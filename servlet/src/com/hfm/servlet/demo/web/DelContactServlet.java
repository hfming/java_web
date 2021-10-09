package com.hfm.servlet.demo.web;

import com.hfm.servlet.demo.daoimpl.ContactDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-14 16:43
 * @Description 删除联系人
 * @date 2020/8/14
 */
@WebServlet(name = "DelContactServlet", urlPatterns = "/delContact")
public class DelContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");

        ContactDAOImpl contactDAO = new ContactDAOImpl();

        contactDAO.delectContact(id);

        // 重定向页面
        response.sendRedirect(request.getContextPath() + "/contacts");
    }
}
