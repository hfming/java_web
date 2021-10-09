package com.hfm.encoding;

import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 15:46
 * @Description
 * @date 2020/8/17
 */
@javax.servlet.annotation.WebServlet(name = "GetDataServlet", urlPatterns = "/getData")
public class GetDataServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //  Http 传输中文数据默认使用 URLEncoder 进行加密
        // 具体的加密编码与 html 页面的编码申明有关
        // 如果不使用通用的获取参数的方法获取参数，则必须使用 URLDecding 进行解码
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("username");
        System.out.println(name);
    }
}
