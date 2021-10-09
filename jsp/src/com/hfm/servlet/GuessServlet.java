package com.hfm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-19 21:38
 * @Description
 * @date 2020/8/19
 */
@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int answer = getAnswer();

        // 1)接收用户输入的幸运数字
        String lucyNoStr = request.getParameter("lucyNo");
        // 用于存储结果
        String msg = "";
        // 用于存储竞猜次数
        int times = 0;

        // 获取用户当前竞猜次数
        String timesStr = request.getParameter("times");
        if (timesStr != null && !timesStr.equals("")) {
            times = Integer.parseInt(timesStr);
            times++;
        }

        if (lucyNoStr != null && !lucyNoStr.equals("")) {
            if (times < 4) {
                // 转型
                int lucyNo = Integer.parseInt(lucyNoStr);

                // 然后和answer进行比较
                if (lucyNo < answer) {
                    // 小了
                    msg = "可惜，小了点";
                } else if (lucyNo > answer) {
                    // 大了
                    msg = "可惜，大了点";
                } else {
                    // 对了
                    msg = "恭喜你，中了1000000大奖，请携带个人有效证件到指定地点兑换奖金";
                    answer = getAnswer();
                    times = -1;
                }
            } else {
                msg = "超过了5次机会，请重新再来";
                // 重新再生成新的答案
                answer = getAnswer();
                times = -1;
            }
            // 把结果存储到域对象中
            request.setAttribute("msg", msg);
            // 把次数返回给yoghurt
            request.setAttribute("timesStr", "，你还有" + (4 - times) + "次机会");
            request.setAttribute("times", times);
            // 转发
            request.getRequestDispatcher("/EL/guess.jsp").forward(request, response);
        }
    }

    private int getAnswer() {
        Random random = new Random();
        return (int) Math.ceil(random.nextInt(30));
    }
}
