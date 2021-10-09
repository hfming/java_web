package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 16:33
 * @Description
 * @date 2020/8/21
 */
public class WhenTag extends SimpleTagSupport {
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

            // 获取父标签
            ChooseTag chooseTag = (ChooseTag)getParent();
            // 将父标签的flag 属性进行赋值
            chooseTag.setFlag(test);
        }
    }
}
