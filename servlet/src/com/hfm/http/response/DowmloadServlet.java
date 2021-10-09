package com.hfm.http.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 20:48
 * @Description Content-Disposition 以下载方式打开资源
 * @date 2020/8/12
 */
@WebServlet(name = "DowmloadServlet", urlPatterns = "/dowmload")
public class DowmloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        //response.setContentType("text/html;charset=utf-8");
//        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("charset=utf-8");
        File file = new File("D:\\Code\\java_web\\html\\Resourecs\\image\\1.jpg");

        // 告诉浏览器以下载的方式打开
        // in-line:默认值,在当前页面内打开
        // attachment;filename=xxx：以附件形式打开响应体。文件下载
        response.setHeader("content-disposition", "attachment;filename=" + file.getName());

        // 真实服务器路径
//        String realPath = getServletContext().getRealPath("\\img\\1.jpg");
//        File file = new File(realPath);
//        FileInputStream fileInputStream = new FileInputStream(file);

        FileInputStream fileInputStream = new FileInputStream(file);
        // 设置响应头
        String mimeType = getServletContext().getMimeType(file.getName());
        response.setHeader("Content-Type",mimeType);

        ServletOutputStream outputStream = response.getOutputStream();
        int length;
        byte[] bytes = new byte[1024];

        while ((length = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,length);
        }

        // 关闭资源
        outputStream.close();
        fileInputStream.close();
    }
}
