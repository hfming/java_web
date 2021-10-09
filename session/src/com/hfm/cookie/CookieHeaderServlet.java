package com.hfm.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 16:16
 * @Description cookie 对象的基本使用
 * @date 2020/8/17
 */
@WebServlet(name = "CookieHeaderServlet", urlPatterns = "/cookieHeader")
public class CookieHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 1.创建 cookie 对象
        Cookie cookie = new Cookie("username", "hfm");

        // 2.服务器发送 cookie 对象个浏览器，
        response.setHeader("set-cookie","username=hfm");

        // 获取第二次请求的 cookie 数据
        String recookie = request.getHeader("Cookie");
        System.out.println(recookie);
    }
}
