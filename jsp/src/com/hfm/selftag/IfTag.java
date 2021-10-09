package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 16:10
 * @Description 高仿 c:if 标签
 * @date 2020/8/21
 */
public class IfTag extends SimpleTagSupport {
    /**
     * test 成员变量,用于存储属性值
     */
    private Boolean test;

    public void setTest(Boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // 根据属性值控制是否输出标签体内容
        if (test) {
            getJspBody().invoke(null);
        }
    }
}
