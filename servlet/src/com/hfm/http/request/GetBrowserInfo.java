package com.hfm.http.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 22:23
 * @Description 获取浏览器信息
 * @date 2020/8/11
 */
@WebServlet(name = "GetBrowserInfo", urlPatterns = "/browserInfo")
public class GetBrowserInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String browser = request.getHeader("User-Agent");
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.59 Safari/537.36 Edg/85.0.564.30
        System.out.println(browser);
        if (browser.contains("Firefox")) {
            System.out.println("火狐浏览器");
        } else if (browser.contains("Chrome") && !browser.contains("Edg")) {
            System.out.println("谷歌浏览器");
        } else if (browser.contains("Trtiden")) {
            System.out.println("IE浏览器");
        } else if (browser.contains("Chrome") && browser.contains("Edg")) {
            System.out.println("MicroSotf Edge");
        }
    }
}
