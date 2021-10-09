package com.hfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 22:17
 * @Description servlet 生命周期
 * @date 2020/8/12
 */
@WebServlet(name = "ServletLife",urlPatterns = "/servletlife")
public class ServletLife extends HttpServlet {
    /**
     * 构造函数
     */
    public ServletLife(){
        super();
        System.out.println("1. 构造函数调用，创建 Servlet 对象");
    }

    /**
     * Servlet 初始化方法
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("2. 初始化方法调用");
    }
    /**
     * Servlet 服务方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("3. 服务方法调用");
        // service 中非判断请求的方式，通过不同的方式调用不同的 doxx 方法处理请求
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("4. 销毁方法，servlet 对象死亡");
    }
}
