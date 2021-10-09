package com.hfm.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 16:32
 * @Description 通过 cookie 对象及其方法传递cookie 数据
 * @date 2020/8/17
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Cookie传送中文时需要加密
        String name = URLEncoder.encode("中文@163.com", "utf-8");

        // 1.创建 cooike 对象
        Cookie cookie = new Cookie("username", name);

        // 2.设置 cookie
        // 先设置后添加
        // 设置生命周期 单位秒
        cookie.setMaxAge(200);

        // 设置 cookie 有效路径
        cookie.setPath("/");

        // 设置 cookie 的值
        // coookie.setValue("value");

        // 3.服务器向浏览器传递cookie 对象
        response.addCookie(cookie);

        // 服务器获取第二次请求携带的 cookie 对象
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie myCookie : cookies) {
                // cookie接收数据时需要解密
//                String decode = URLDecoder.decode(myCookie.getValue(), "utf-8");
                String decode = myCookie.getValue();
                System.out.println(myCookie.getName() + ":" + decode);
            }
        }
    }
}
