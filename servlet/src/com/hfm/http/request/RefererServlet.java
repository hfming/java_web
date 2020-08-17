package com.hfm.http.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 22:40
 * @Description referer 防盗链
 * @date 2020/8/11
 */
@WebServlet(name = "RefererServlet", urlPatterns = "/refererServlet")
public class RefererServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // referer 表示当前请求来自哪里

        String referer = request.getHeader("referer");
        System.out.println(referer);
        if (referer == null || referer.contains("Referer.html")) {
            response.getWriter().write("非法请求");
        } else {
            response.getWriter().write("请求成功");
        }
    }
}
