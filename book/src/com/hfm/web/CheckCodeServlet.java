package com.hfm.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "CheckCodeServlet", urlPatterns = "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 80;
        int height = 40;

        // 创建图片对象
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 图片设置
        // 获取画笔对象，该对象可以用来画画
        Graphics graphics = bufferedImage.getGraphics();
        //
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, width, height);

        // 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        String myCode = "";
        // 设置验证码
        graphics.setColor(Color.BLACK);
        int num = 5;
        for (int i = 1; i <= num; i++) {
            char c = code.charAt(random.nextInt(code.length()));
            myCode += c;
            // 将字符写出
            graphics.drawString(c + "", (width / (num + 1)) * i, 10 + random.nextInt(height - 10 * 2));
        }

        // 划线
        graphics.setColor(Color.RED);
        for (int i = 0; i < 6; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 画出图片
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

        // 用来保存验证码
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("code", myCode);
    }
}
