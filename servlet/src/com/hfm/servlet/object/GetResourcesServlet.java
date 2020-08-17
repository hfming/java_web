package com.hfm.servlet.object;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 19:28
 * @Description
 * @date 2020/8/13
 */
@WebServlet(name = "GetResourcesServlet", urlPatterns = "/getResources")
public class GetResourcesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 获取 ServletContext 对象
        ServletContext servletContext = this.getServletContext();

        // 获取文件真实路径信息 ，得到资源文件的绝对路径,服务器行为，只能访问当前项目的路径
        // 只能访问 web 文件夹下的文件
        String realPath = servletContext.getRealPath("/static/html/FormTest.html");
        System.out.println(realPath);

        //获取资源(返回URL路径信息),服务器行为，只能访问当前项目的路径
        URL resource = servletContext.getResource("/static/html/FormTest.html");
        System.out.println(resource.getFile().toString());

        // 在 web 路径中不能使用相对路径 .

        // 获取指定文件的输入字符流,服务器行为，只能访问当前项目的路径
        InputStream resourceAsStream = servletContext.getResourceAsStream("/static/html/FormTest.html");
        int length;
        byte[] bytes = new byte[1024 << 4];
        while ((length = resourceAsStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,length));
        }
    }
}
