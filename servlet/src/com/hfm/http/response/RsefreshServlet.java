package com.hfm.http.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 19:09
 * @Description
 * @date 2020/8/12
 */
@WebServlet(name = "RsefreshServlet", urlPatterns = "/resfresh")
public class RsefreshServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("uft-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置 content-type 响应头
        response.setHeader("content-type","text/html;charset=utf-8");

        // 简化版本
        // text/html 设置浏览器解析格式
        // charset=utf-8 设置字符编码
        response.setContentType("text/html;charset=utf-8");

        // 设置refresh响应头
        // 设置秒数
        //response.setHeader("refresh", "2");
        // 每隔n秒跳转页面
        response.getWriter().write("注册成功！3秒之后会跳转到主页");
        // 设置定时跳转
        response.setHeader("refresh", "3;/servlet/responseTest");


    }
}
