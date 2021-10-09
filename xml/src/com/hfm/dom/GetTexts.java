package com.hfm.dom;

import com.hfm.contact.util.XMLManager;
import org.dom4j.Element;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-06 22:22
 * @Description 获取 XML 标签中的文本信息
 * @date 2020/8/6
 */
public class GetTexts {
    public static void main(String[] args) {
        // 调用工具类中的方法，获取 XML 文件的根节点
        Element rootElement = XMLManager.getRootElement("xml\\xml\\students.xml");

        Element name = rootElement.element("student").element("name");

        // 获取标签文本
        String text = name.getText();
        System.out.println(text);

        // 通过父标签获取指定子标签的文本
        String nameText = rootElement.element("student").elementText("name");
        System.out.println(nameText);

        // 在 XMl 文件中，空格和换行会作为 xml 的内容被解析
        // java 代码中的空格和换行没有意义
        System.out.println(rootElement.getText());
        System.out.println(rootElement.element("student").getText());
    }
}
