package com.hfm.servlet.create;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 11:10
 * @Description 第一个 servlet
 * @date 2020/8/11
 */
public class ExtendsHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符编码
        resp.setContentType("text/html;charset=utf-8");
        // 向浏览器写出
        resp.getWriter().write("当前的时间"+ new Date());
    }
}
