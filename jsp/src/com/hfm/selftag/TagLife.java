package com.hfm.selftag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 11:28
 * @Description
 * @date 2020/8/21
 */
public class TagLife extends SimpleTagSupport {
    /**
     * 构造函数
     */
    public TagLife() {
        super();
        System.out.println("子标签构造函数");
    }

    @Override
    public void setJspContext(JspContext pc) {
        System.out.println("子标签 setJspContext");
    }

    @Override
    public void setParent(JspTag parent) {
        // 没有父标签不会调用
        System.out.println("子标签 setParent");
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        // 没有标签体内容也不会调用
        System.out.println("子标签 setJspBody");
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("子标签 doTag");
        // 执行标签体内容需要手动调用,如果有子标签则调用子标签标签处理程序

//        // 获取标签体内容对象
//        JspFragment jspBody = this.getJspBody();
//
//        // 输出标签体内容
//        jspBody.invoke(getJspContext().getOut());
    }
}
