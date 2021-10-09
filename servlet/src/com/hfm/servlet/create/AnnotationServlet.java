package com.hfm.servlet.create;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 11:34
 * @Description 注解开发 servlet
 * urlPatterns 可以直接在注解中设置 servlet 的访问路径
 * @date 2020/8/11
 */
@WebServlet(urlPatterns = "/anServlet")// 可以配置多个路径 @WebServlet({"/d4","/dd4","/ddd4"})
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符编码
        resp.setContentType("text/html;charset=utf-8");
        // 向浏览器写出
        resp.getWriter().write("注解开发 servlet - 当前的时间" + new Date());
    }
}
