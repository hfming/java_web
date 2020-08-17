package com.hfm.http.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 19:00
 * @Description location + 303 状态码 进行请求重定向
 * @date 2020/8/12
 */
@WebServlet(name = "RedirectServlet",urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置状态码 303
        response.setStatus(303);
        // 设置location响应头
        // 第二个参数时说 URI 地址
        response.setHeader("location","/servlet/responseTest");

        // 简化方式 等价于上述两步
        response.sendRedirect("/servlet/responseTest");
    }
}
