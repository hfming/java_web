package com.hfm.servlet.demo.web;

import com.hfm.servlet.demo.daoimpl.ContactDAOImpl;
import com.hfm.servlet.demo.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-14 15:42
 * @Description
 * @date 2020/8/14
 */
@WebServlet(name = "ContactsServlet", urlPatterns = "/contacts")
public class ContactsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ContactDAOImpl contactDAO = new ContactDAOImpl();

        List<Contact> contacts = contactDAO.allContact();

        request.setAttribute("contacts",contacts);
        request.getRequestDispatcher("/jsp/contacts.jsp").forward(request,response);

//        String html = "<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "\n" +
//                "\t<head>\n" +
//                "\t\t<meta charset=\"UTF-8\">\n" +
//                "\t\t<title>查询所有联系人</title>\n" +
//                "\t\t<link rel=\"stylesheet\" href=\"/servlet/static/css/table.css\" />\n" +
//                "\t</head>\n" +
//                "\n" +
//                "\t<body>\n" +
//                "\t\t<table align=\"center\" border=\"1px\" cellspacing=\"0px\" width=\"1000px\">\n" +
//                "\t\t\t<thead>\n" +
//                "\t\t\t\t<caption>联系人列表</caption>\n" +
//                "\t\t\t\t<tr>\n" +
//                "\t\t\t\t\t<th>编号</th>\n" +
//                "\t\t\t\t\t<th>姓名</th>\n" +
//                "\t\t\t\t\t<th>性别</th>\n" +
//                "\t\t\t\t\t<th>年龄</th>\n" +
//                "\t\t\t\t\t<th>电话</th>\n" +
//                "\t\t\t\t\t<th>邮箱</th>\n" +
//                "\t\t\t\t\t<th>地址</th>\n" +
//                "\t\t\t\t\t<th>操作</th>\n" +
//                "\t\t\t\t</tr>\n" +
//                "\t\t\t</thead>\n" +
//                "\t\t\t<tbody>\n";
//        if (contacts != null) {
//            for (Contact contact : contacts) {
//                html += "\t\t\t\t<tr>\n" +
//                        "\t\t\t\t\t<td>" + contact.getId() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getName() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getGender() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getAge() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getPhone() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getEmail() + "</td>\n" +
//                        "\t\t\t\t\t<td>" + contact.getAddress() + "</td>\n" +
//                        "\t\t\t\t\t<td>\n" +
//                        "\t\t\t\t\t\t<a href=\"" + request.getContextPath() + "/showContact?id=" + contact.getId() + "\">【修改】</a>\n" +
//                        "\t\t\t\t\t\t<a href=\"" + request.getContextPath() + "/delContact?id=" + contact.getId() + "\">【删除】</a>\n" +
//                        "\t\t\t\t\t</td>\n" +
//                        "\t\t\t\t</tr>\n" +
//                        "\n";
//            }
//        }
//        html += "\t\t\t</tbody>\n" +
//                "\t\t\t<tfoot>\n" +
//                "\t\t\t\t<tr>\n" +
//                "\t\t\t\t\t<td colspan=\"7\">\n" +
//                "\t\t\t\t\t\t<a href=\"/servlet/static/html/AddContact.html\">【添加联系人】</a>\n" +
//                "\t\t\t\t\t</td>\n" +
//                "\t\t\t\t</tr>\n" +
//                "\t\t\t</tfoot>\n" +
//                "\t\t</table>\n" +
//                "\t</body>\n" +
//                "\n" +
//                "</html>";
//        response.getWriter().write(html);
    }
}
