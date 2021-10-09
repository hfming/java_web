package com.hfm.selftag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-20 19:16
 * @Description 自定义标签处理程序
 * @date 2020/8/20
 */
public class ShowIpTag extends SimpleTagSupport {
    /**
     * 重写 doTag 方法
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        // 将jspContext 强制转换为 PageContext
        PageContext pageContext = (PageContext) this.getJspContext();

        // 通过 PageContext 对象获取 ServletRequest 对象
        ServletRequest request = pageContext.getRequest();

        String ip = request.getRemoteHost();

        // 获取 out 对象
        JspWriter out = pageContext.getOut();

        // 输出数据
        out.print("当前 IP 地址:" + ip);
    }
}
