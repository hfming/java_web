package com.hfm.servlet.create;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 16:57
 * @Description
 * @date 2020/8/11
 */
public class AutoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码
        response.setContentType("text/html;charset=utf-8");
        // 向浏览器写出
        response.getWriter().write("IDEA 自动生成 Servlet - 当前时间：" + new Date());
    }
}
