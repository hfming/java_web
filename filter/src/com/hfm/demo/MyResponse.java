package com.hfm.demo;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-30 12:10
 * @Description HttpServletResponse 装饰者类
 * @date 2020/8/30
 */
public class MyResponse extends HttpServletResponseWrapper {
    /**
     * 用于保存 HttpServletResponse 对象
     */
    private HttpServletResponse httpServletResponse;

    public MyResponse(HttpServletResponse response) {
        super(response);
        this.httpServletResponse = response;
    }

    /**
     * 一个带缓冲容器对象
     */
    private CharArrayWriter charArrayWriter = new CharArrayWriter();

    public CharArrayWriter getCharArrayWriter() {
        return charArrayWriter;
    }

    /**
     * 重写 getWrite 方法，让其返回带有缓冲功能的 printwrite
     * @return
     * @throws IOException
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        // 创建带有一个 charArrayWriter 缓冲容器的 PrintWrite
        // 如果调用带有缓冲区的 PrintWrite 的 write 方法，那么网页内容会直接写入到 charArrayWriter 缓冲容器中
        super.getWriter();
        return new PrintWriter(charArrayWriter);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }
}
