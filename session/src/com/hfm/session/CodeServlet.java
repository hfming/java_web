package com.hfm.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-15 16:27
 * @Description 服务器生成验证码并发送给浏览器
 * @date 2020/8/15
 */
@WebServlet(name = "CodeServlet", urlPatterns = "/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建图片对象
        BufferedImage bufferedImage = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);

        StringBuilder stringBuilder = new StringBuilder();

        // 图片设置
        // 获取画笔对象，该对象可以用来画画
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, 100, 50);

        // 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, 99, 49);

        String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        // 设置验证码
        graphics.setColor(Color.BLACK);
        for (int i = 1; i <= 6; i++) {
            int index = random.nextInt(code.length());
            char c = code.charAt(index);
            stringBuilder.append(c);
            graphics.drawString(c + "", 15 * i, 10 + random.nextInt(30));
        }
        // 将验证码添加到 Session 中
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",stringBuilder.toString());

//        graphics.drawString("D", 20, 25);
//        graphics.drawString("R", 40, 25);
//        graphics.drawString("X", 60, 25);
//        graphics.drawString("I", 80, 25);

        // 划线
        graphics.setColor(Color.RED);
        for (int i = 0; i < 6; i++) {
            int x1 = random.nextInt(100);
            int x2 = random.nextInt(100);
            int y1 = random.nextInt(50);
            int y2 = random.nextInt(50);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 画出图片
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
}
