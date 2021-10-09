package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 12:21
 * @Description 自定义标签的功能
 * @date 2020/8/21
 */
public class TagFunction extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // 执行标签体内容,如果有子标签会调用子标签的标签处理程序
        // 获取标签体内容对象
        JspFragment jspBody = this.getJspBody();

        // 输出标签体内容
        // invoke 执行片段并指示所有输出到给定的 Writer，或者由与片段关联的 JspContext 的 getOut（） 方法返回的 JspWriter（如果 out 为 null）。
        JspWriter out = getJspContext().getOut();

        // 将标签体内容通过 JspWriter 输出到浏览器
        // invoke 默认为 null 也是输出到浏览器
        jspBody.invoke(out);

        // 抛出一个普通的运行时异常时页面会出现 500 错误
//        throw new RuntimeException();

        // 抛出一个 SkipPageException 异常页面不会出现错误而是继续显示
        // 通常 SkipPageException 与if-else 语句一起使用,用于中断页面输出
        if (1 > 2) {
            throw new SkipPageException();
        }else{
            out.print("控制输出<br/>");
        }
        out.print("后续输出<br/>");

        // 改变标签体内容
        // 1.获取标签体内容对象 jspBody
        //  JspFragment jspBody = this.getJspBody();

        // StringWriter 字符串流,也是带有缓冲区的流,类似于StringBiffer
        // 2.创建 StringWrite 对象用于存储标签体容
        StringWriter stringWriter = new StringWriter();
        // 3.进标签体内容放到 StringWriter 字符串流 中
        jspBody.invoke(stringWriter);

        // 4.得到标签体内容
        String newJspBody = stringWriter.toString();
        // 5.修改标签体内容
        newJspBody = "新的标签体内容";

        // 6.将标签体内容输出

        // 不能使用该方法输出新的标签体内容,因为它是默认输出,只会输出原标签体内容
        jspBody.invoke(null);

        // 手动输出新标签体内容
        getJspContext().getOut().write(newJspBody);
    }
}
