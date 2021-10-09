package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 13:58
 * @Description 自定义标签属性
 * @date 2020/8/21
 */
public class TagAttribute extends SimpleTagSupport {
    /**
     * 属性作为成员变量
     * 1）声明一个成员变量用于接收标签属性值
     */
    private int num;

    /**
     * 设置一个 set 方法给属性值进初始化
     * 用于把外面标签的属性值传入进来
     */
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // 使用属性
        for (int i = 0; i < num; i++) {
            getJspBody().invoke(null);
        }
    }
}
