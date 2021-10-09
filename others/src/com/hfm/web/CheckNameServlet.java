package com.hfm.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-31 22:25
 * @Description 校验用户名是否可用
 * @date 2020/8/31
 */
@WebServlet(name = "CheckNameServlet", urlPatterns = "/checkName")
public class CheckNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的数据格式为 JSON
        response.setContentType("application/json;charset=UTF-8");

        // 获取用户名
        String username = request.getParameter("username");
        Map<String, Object> map = new HashMap<>();

        // 调用 server 实现类查询数据库，判断用户名是否存在
        if ("hfm".equalsIgnoreCase(username)) {
            map.put("userExsit", true);
            map.put("message","此用户名太受欢迎，请更换一个");
        }else{
            map.put("userExsit", false);
            map.put("message","用户名可用");
        }

        // 将 map 转为 JSON字符串，并传递到页面上
        ObjectMapper objectMapper = new ObjectMapper();

        // 将数据传递给客户端
        objectMapper.writeValue(response.getWriter(),map);
    }
}
