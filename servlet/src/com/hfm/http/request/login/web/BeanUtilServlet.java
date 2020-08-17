package com.hfm.http.request.login.web;

import com.hfm.http.request.login.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 14:19
 * @Description
 * @date 2020/8/15
 */
@WebServlet(name = "BeanUtilServlet", urlPatterns = "/beanUtil")
public class BeanUtilServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取参数的map 集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        
        // 创建空对象
        User user = new User();

        try {
            // 使用 BeanUtil 封装数据
            BeanUtils.populate(user,parameterMap);

            System.out.println(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
