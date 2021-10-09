package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 16:34
 * @Description
 * @date 2020/8/21
 */
public class OtherwiseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // 获取父标签
        ChooseTag chooseTag = (ChooseTag) getParent();
        if (!chooseTag.isFlag()) {
            getJspBody().invoke(null);
        }
    }
}
