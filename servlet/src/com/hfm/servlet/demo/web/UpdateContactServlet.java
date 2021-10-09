package com.hfm.servlet.demo.web;

import com.hfm.servlet.demo.daoimpl.ContactDAOImpl;
import com.hfm.servlet.demo.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-14 16:17
 * @Description
 * @date 2020/8/14
 */
@WebServlet(name = "UpdateContactServlet", urlPatterns = "/updateContact")
public class UpdateContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 创建 DAO 实现类对象
        ContactDAOImpl contactDAO = new ContactDAOImpl();
        Contact contact = new Contact();

        contact.setId(request.getParameter("id"));
        contact.setName(request.getParameter("name"));
        contact.setGender(request.getParameter("gender"));
        contact.setAddress(request.getParameter("adderss"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));
        contact.setAge(Integer.parseInt(request.getParameter("age")));
        // XML 添加联系人
        contactDAO.updateContact(contact,request.getParameter("id"));

        // 页面跳转,重定向
        response.sendRedirect(request.getContextPath() + "/contacts");
    }
}
