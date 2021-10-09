package com.hfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 11:42
 * @Description
 * @date 2020/8/13
 */
@WebServlet(name = "ThreadServlet", urlPatterns = "/threadServlet")
public class ThreadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    private static int count;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        synchronized (this.getClass()) {
            response.getWriter().write("第" + ++count + "个请求");
        }
    }

    /**
     * 同步函数
     */
    private synchronized static void getCount(HttpServletResponse response) throws IOException {
        response.getWriter().write("第" + ++count + "个请求");
    }
}
