package com.hfm.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-03 21:51
 * @Description 验证码校验
 * @date 2021/10/3
 */
@WebServlet(name = "CheckCodeServlet", urlPatterns = "/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();

        String code = (String) session.getAttribute("code");
        // 获取之后删除，让验证码只有一次有效
        session.removeAttribute("code");

        if (code != null && checkCode != null && code.trim().equalsIgnoreCase(checkCode.trim())) {
            System.out.println("验证码正确");
        }else{
            System.out.println("验证码错误");
        }
    }
}
