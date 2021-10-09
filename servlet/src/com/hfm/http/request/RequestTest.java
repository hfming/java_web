package com.hfm.http.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 19:56
 * @Description HttpServletRequest 获取请求信息
 * @date 2020/8/11
 */
@WebServlet(name = "RequestTest", urlPatterns = "/requestTest")
public class RequestTest extends HttpServlet {
    /**
     * post 请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将 post 请求转换成 get 请求
        doGet(request, response);
    }

    /**
     * request 请求的方式总共有七种，在 HttpServlet 中对应七种接收请求的方法
     * server 方法是在 Servlet 接口中定义的，HttpServlet 实现了 Servlet 接口重写server 方法，并在 server 方法中对请求类型进行判断
     * servlet 方法是 Servlet 程序的入口，在 HttpServlet 源码的 server 方法中可以根据不同的方法调用不同的 doxx 方法
     * 不同的请求类型调用不同的方法进行处理 get 方法调用 doGet,post 方法调用 doPost
     * 开发 Servlet 时不需要覆盖 seerver 方法，而是覆盖 doxx 方法
     * get 与 post 请求是最常用的请求，只需要重写doGet 与 doPost 方法即可。
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * get 请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.tomcat 服务器收到浏览器发出的请求数据
        // 2.tomcat 服务器把请求数据封装成 HttpServletRequest 对象
        // 3.tomcat 服务器调用 doGet 方法，把 HttpServletRequest 对象传入 servlet
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 4.通过 HttpServletRequest 对象获取请求数据
        // 4.1.获取请求行
        // 请求方式
        System.out.println("请求方式:" + request.getMethod());
        // 请求资源
        System.out.println("URI:" + request.getRequestURI());
        System.out.println("URL:" + request.getRequestURL());
        // Http 版本
        System.out.println("HTTP 版本:" + request.getProtocol());

        // 4.2.获取指定请求头
        // 根据请求头名称获取请求头数据
        System.out.println("Host" + request.getHeader("Host"));

        // 获取使用 请求头名称 的集合
        Enumeration<String> headerNames = request.getHeaderNames();
        // 迭代获取请求头数据
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + ":" + request.getHeader(name));
        }
        // 获取相同请求头的集合,一般不存在相同请求头，也就是说唯一
        // Enumeration<String> host = request.getHeaders("Host");

        // 4.3.获取实体内容
        // 只有 post 请求才有实体内容
        // BufferedReader getReader()：获取字符输入流，只能操作字符数据
        // ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
        ServletInputStream inputStream = request.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int length = 0;
        while ((length = bufferedInputStream.read()) != -1) {
            System.out.print((char) length);
        }
    }
}
