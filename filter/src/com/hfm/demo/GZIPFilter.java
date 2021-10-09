package com.hfm.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 11:36
 * @Description GZIP 网页压缩
 * @date 2020/8/30
 */
//@WebFilter(filterName = "GZIPFilter", urlPatterns = "/*")
public class GZIPFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("GZIP 过滤器压缩网页 - 启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("GZIP 过滤器压缩网页 - 执行前");
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 得到压缩前的内容，response 没有方法获取实体内容
        // 现在 response 对象的 getWrite() 方法得到的是没有缓冲功能的PrintWrite(),调用 write() 方法就是直接将内容输出到浏览器中
        // 通过改造 response 的 getWrite 方法，从而得到一个带有缓存功能的 PrintWrite 对象，那么 write() 方法写出的网页内容就是写道缓存区中,我们就可以从缓冲区中得到网页的内容
        // 1.创建 HttpServletResponse 装饰者类，增强 write 方法
        MyResponse myResponse = new MyResponse(response);

        // 放行,
        filterChain.doFilter(servletRequest, myResponse);
        System.out.println("GZIP 过滤器压缩网页 - 执行后");

        // 3.压缩数据
        // 创建临时缓存容器
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 创建 GZIPOutputStream 流
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        // 2.获取带缓冲的CharArrayWriter, 缓冲区中存储的就是网页数据，在获取网页内容
        // 之后进行数据压缩,写回到 byteArrayOutputStream
        gzipOutputStream.write(new String(myResponse.getCharArrayWriter().toCharArray()).getBytes("utf-8"));
        // 调用finish() 刷新缓存
        gzipOutputStream.finish();

        // 获取 GZIP 压缩后去内容后必须要告诉浏览器数据输出的格式于内容
        myResponse.setHeader("content-encoding","gzip");
        // 从临时缓存容量中获取压缩后的数据
        // 将压缩后的数据发送到浏览器
        myResponse.getOutputStream().write(byteArrayOutputStream.toByteArray());
    }

    @Override
    public void destroy() {
        System.out.println("GZIP 过滤器压缩网页 - 销毁");
    }
}
