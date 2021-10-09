package com.hfm.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-07 20:35
 * @Description
 * @date 2021/10/7
 */
@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        String password = request.getParameter("password");
        System.out.println(password);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue( response.getWriter(),"name=" + name + ";password=" + password);
    }
}
