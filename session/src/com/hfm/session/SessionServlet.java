package com.hfm.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 23:08
 * @Description
 * @date 2020/8/17
 */
@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1.获取session对象
        HttpSession session = request.getSession();
        System.out.println("session:" + session);

        //2.设置有效时间
        session.setMaxInactiveInterval(10000);

        //3.手动销毁
        //session.invalidate();

        //4.保存会话数据
        // 保存数据
//        session.setAttribute("name", "hfm");

        // 获取数据
        System.out.println(session.getAttribute("name"));

        // 删除数据
        //session.removeAttribute("name");

        // 设置JSESSIONID的时间，不会随着浏览器关闭而丢失！
        Cookie c = new Cookie("JSESSIONID", session.getId());
        // 1个月
        c.setMaxAge(1 * 30 * 24 * 60 * 60);
        response.addCookie(c);

        // 创建或得到session对象，查询session对象，如果没有sessino对象，则创建新的session对象
        request.getSession(true);
        // 得到session对象。 查询session对象，如果没有session对象，直接返回null
        request.getSession(false);
    }
}
