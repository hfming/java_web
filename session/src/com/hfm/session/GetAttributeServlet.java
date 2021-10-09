package com.hfm.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 22:52
 * @Description
 * @date 2020/8/17
 */
@WebServlet(name = "GetAttributeServlet", urlPatterns = "/getAttribute")
public class GetAttributeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 创建 HttpSession 对象
        HttpSession session = request.getSession();

        String name =(String) session.getAttribute("name");
        System.out.println(name);
    }
}
