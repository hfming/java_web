package com.hfm.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-01 21:50
 * @Description
 * @date 2020/9/1
 */
@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件下载 - 开始");
        String fileName = "世界地图 1.jpg";
        String realPath = getServletContext().getRealPath("/video/" + fileName);

        String ua = request.getHeader("User-Agent");
            // 判断是否是火狐浏览器
        if(ua.contains("Firefox")){
            // 使用下面的格式进行 BASE64 编码后
            // Java 8的java.util套件中，新增了Base64的类别，可以用来处理Base64的编码与解码
            Base64.Encoder encoder = Base64.getEncoder();
            // 进行 Base64 编码
            String s = encoder.encodeToString(fileName.getBytes("utf-8"));
            // 拼串
            String str = "atachment; fileName=" + "=?utf-8?B"+ s + "?=";
            // 设置到响应头中
            response.setHeader("Content-Dispositon", str);
        }else{
            // 把中文名进行 UTF-8 编码操作。中文名需要 URLEncode 编码
            String encodeName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
            // 然后把编码后的字符串设置到响应头中
            // response设置下载文件名无效。因为response 参数设置要在out对象加入数据之前
            // 设置响应头 这个响应头告诉浏览器。这是需要下载的。
            // atachment 表示附件，也就是下载的一个文件。fileName=后面，表示下载的文件名。
            response.addHeader("Content-Disposition", "attachment;filename=" + encodeName);
        }

        // 获取文件类型
        String mimeType = getServletContext().getMimeType(realPath);

        // 设置文件输出类型
        response.setContentType(mimeType);

        // 获取 InputStream 文件输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);

        // 获取浏览器输出流
        ServletOutputStream outputStream = response.getOutputStream();

        // 使用 IOIOUtils 工具类复制文件
        IOUtils.copy(fileInputStream, outputStream);
    }
}
