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
public class ChooseTag extends SimpleTagSupport {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // 输出标签体的内容
        getJspBody().invoke(null);
    }
}
