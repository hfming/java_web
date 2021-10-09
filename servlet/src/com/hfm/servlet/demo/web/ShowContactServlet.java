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
 * @version 1.01 2020-08-14 17:23
 * @Description
 * @date 2020/8/14
 */
@WebServlet(name = "ShowContactServlet", urlPatterns = "/showContact")
public class ShowContactServlet extends HttpServlet {
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

        Contact contact = contactDAO.findContactById(id);

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>修改联系人</title>\n" +
                "\t</head>\n" +
                "\n" +
                "\t<body>\n" +
                "\t\t<form action=\"/servlet/updateContact\" method=\"post\" target=\"_self\">\n" +
                "\t\t\t<table border=\"1px\" align=\"center\" cellspacing=\"0px\" width=\"50%\">\n" +
                "\t\t\t\t<thead>\n" +
                "\t\t\t\t\t<caption>修改联系人</caption>\n" +
                "\t\t\t\t</thead>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<th>输入项</th>\n" +
                "\t\t\t\t\t\t<th>输入框</th>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"name\">姓名</label></td>\n" +
                "\t\t\t\t\t\t<td><input type=\"text\" value=\"" + contact.getName() + "\" id=\"name\" name=\"name\"/></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"gender\">性别</label></td>\n" +
                "\t\t\t\t\t\t<td>\n";
        if ("boy".equals(contact.getGender())) {
            html += "\t\t\t\t\t\t\t<input type=\"radio\" value=\"boy\" id=\"gender\" name=\"gender\" checked=\"checked\" />男\n" +
                    "\t\t\t\t\t\t\t<input type=\"radio\" value=\"girl\" id=\"gender\" name=\"gender\" />女\n";
        } else {
            html += "\t\t\t\t\t\t\t<input type=\"radio\" value=\"boy\" id=\"gender\" name=\"gender\" />男\n" +
                    "\t\t\t\t\t\t\t<input type=\"radio\" value=\"girl\" id=\"gender\" name=\"gender\" checked=\"checked\"/>女\n";
        }
        // 隐藏域传递数据
        html += "<input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + contact.getId() + "\"/>";
        html += "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"age\">年龄</label></td>\n" +
                "\t\t\t\t\t\t<td><input type=\"number\" value=\"" + contact.getAge() + "\" id=\"age\" name=\"age\" /></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"phone\">电话</label></td>\n" +
                "\t\t\t\t\t\t<td><input type=\"text\" value=\"" + contact.getPhone() + "\"  id=\"phone\" name=\"phone\"/></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"email\">邮箱</label></td>\n" +
                "\t\t\t\t\t\t<td><input type=\"email\" value=\"" + contact.getEmail() + "\"  id=\"email\" name=\"email\" /></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td><label for=\"address\">地址</label></td>\n" +
                "\t\t\t\t\t\t<td><input type=\"text\" value=\"" + contact.getAddress() + "\"  id=\"address\" name=\"adderss\"/></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\n" +
                "\t\t\t\t\t\t\t<input type=\"submit\" value=\"确认修改\" />\n" +
                "\t\t\t\t\t\t\t<input type=\"reset\" value=\"重置\" />\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t</form>\n" +
                "\t</body>\n" +
                "\n" +
                "</html>";
        response.getWriter().write(html);
    }
}
