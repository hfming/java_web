package com.hfm.http.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-14 22:18
 * @Description
 * @date 2020/8/14
 */
@WebServlet(name = "RequestSetAttributeServlet", urlPatterns = "/requestSetAttribute")
public class RequestSetAttributeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("test", "测试");
        // request 域只有在一次请求的时候用来传递数据，因此只能用于请求转发
        request.getRequestDispatcher("/requestGetAttribute").forward(request,response);
    }
}
