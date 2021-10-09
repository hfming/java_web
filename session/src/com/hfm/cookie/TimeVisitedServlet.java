package com.hfm.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 17:04
 * @Description
 * @date 2020/8/17
 */
@WebServlet(name = "FirstTimeVisitedServlet", urlPatterns = "/timeVisited")
public class TimeVisitedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 创建日期对象
        LocalDateTime now = LocalDateTime.now();
        // 使用自定义格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        // 格式化
        String format = dateTimeFormatter.format(now);
        // 中文需要进行编码
        String encode = URLEncoder.encode(format, StandardCharsets.UTF_8);

        Cookie[] cookies = request.getCookies();
        // 如果已经有 cookie 则显示第一次及上一次访问的时间，否则设置第一次访问的时间
        StringBuilder out = new StringBuilder();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();

                // 中文需要进行解码
                String decode = URLDecoder.decode(value, StandardCharsets.UTF_8);
                if ("LastTime".equalsIgnoreCase(name) || "FirstTime".equalsIgnoreCase(name)) {
                    out.append(name + ":" + decode + "<br/>");
                }
            }
            response.getWriter().write(out.toString());

            // 添加本次访问时间
            Cookie lastTime = new Cookie("LastTime", encode);
            response.addCookie(lastTime);
        } else {
            Cookie firstTime = new Cookie("FirstTime", encode);
            Cookie lastTime = new Cookie("LastTime", encode);
            response.addCookie(firstTime);
            response.addCookie(lastTime);
        }
    }
}
