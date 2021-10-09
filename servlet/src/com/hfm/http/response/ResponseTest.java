package com.hfm.http.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 18:22
 * @Description HttpServletResponse 对象
 * @date 2020/8/12
 */
@WebServlet(name = "ResponseTest", urlPatterns = "/responseTest")
public class ResponseTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置 post 方式码表，服务器端
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 设置响应头，浏览器端
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1）tomcat 服务器提供一个 HttpServletResponse 对象，用于给开发者修改响应数据
        // 2）通过 service 方法把 response 对象传入 servlet 中
        // 3）可以通过 response 对象修改响应信息

        // 修改响应行
        //response.setStatus(404);
        // 设置错误页面
        //response.sendError(404);

        // 设置实体内容
        response.getWriter().write("字符流");

        // 图片、视频、音频 使用字节流进行传输
        response.getOutputStream().write("字节流".getBytes());
    }
}
