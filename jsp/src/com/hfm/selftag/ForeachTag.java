package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 17:21
 * @Description 高仿 foreach 标签
 * begin end step items var varStatus
 * @date 2020/8/21
 */
public class ForeachTag extends SimpleTagSupport {
    /**
     * 起始位置
     */
    private int begin;
    /**
     * 结束位置
     */
    private int end;
    /**
     * 步进
     */
    private int step;
    /**
     * 遍历集合
     */
    private Object items;
    /**
     * 遍历元素
     */
    private String var;

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (items instanceof List){
            List newItem = (List) items;
            foreach(newItem);
        }
        if (items instanceof Map){
            Map newItem = (Map) items;
            Set set = newItem.entrySet();
            foreach(set);
        }
    }

    private void foreach(Collection newItem) throws JspException, IOException {
        Object[] objects = newItem.toArray();
        for (int i = begin; i <= end; i += step) {
            // 把标签体内容输出
            Object o = objects[i];
            getJspContext().setAttribute(var,o);

            this.getJspBody().invoke(null);
        }
    }
}
