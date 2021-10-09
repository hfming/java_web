package com.hfm.selftag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 11:41
 * @Description
 * @date 2020/8/21
 */
public class Parent extends SimpleTagSupport {
    public Parent() {
        super();
        System.out.println("父标签构造函数");
    }

    @Override
    public void setJspContext(JspContext pc) {
        System.out.println("父标签 setJspContext");
    }

    @Override
    public void setParent(JspTag parent) {
        System.out.println("父标签setParent ");
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        System.out.println("父标签 setJspBody");
        super.setJspBody(jspBody);
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("父标签 doTag");
        // 执行标签体内容需要手动调用,如果有子标签则调用子标签标签处理程序
        this.getJspBody().invoke(null);
    }
}
