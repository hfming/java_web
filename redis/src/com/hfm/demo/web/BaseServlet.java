package com.hfm.demo.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-03 15:31
 * @Description Servlet 父类
 * @date 2020/9/3
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    /**
     * 使用反射自动调用子类方法
     *
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        // 判断页面来源
        String action = request.getParameter("action");
        // 默认使用子类 page 方法
        if (action == null || "".equalsIgnoreCase(action.trim()) || "null".equalsIgnoreCase(action.trim())) {
            action = "page";
        }
        try {
            // 获取 action 业务鉴别字段，通过反射来调用方法，可以优化大量 else if 代码
            // 参数一：方法名
            // 参数二及以后: 参数类对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 将私有方法设置成可以调用
            method.setAccessible(true);

            // 反射，调用对应 action 方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //  一定要记得把 BaseSrvlet 中的异常往外抛给 Filter 过滤器, 不然会卡住
            throw new RuntimeException(e);
        }
    }
}
