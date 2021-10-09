package com.hfm.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 11:08
 * @Description 装饰者类
 * @date 2020/8/30
 */
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest httpServletRequest;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.httpServletRequest = request;
    }

    @Override
    public String getParameter(String name) {
        // iso-8859-1
        String parameter = httpServletRequest.getParameter(name);
        try {
            if ("GET".equalsIgnoreCase(httpServletRequest.getMethod())) {
                parameter = new String(parameter.getBytes("iso-8859-1"), "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return parameter;
        }
    }
}
