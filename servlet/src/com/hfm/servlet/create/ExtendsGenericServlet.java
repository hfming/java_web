package com.hfm.servlet.create;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-11 15:55
 * @Description 第二种实现 servlet 方法 继承 GenericServlet 实现 service
 * @date 2020/8/11
 */
public class ExtendsGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 设置字符编码
        servletResponse.setContentType("text/html;charset=utf-8");
        // 向浏览器写出
        servletResponse.getWriter().write("继承 GenericServlet 实现 service - 当前时间：" + new Date());
    }
}
