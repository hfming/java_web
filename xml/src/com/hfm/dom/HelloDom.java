package com.hfm.dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020/8/6
 * @Description
 */
public class HelloDom {
    public static void main(String[] args) {
        // 1.创建 SAXReader 解析器对象
        SAXReader saxReader = new SAXReader();
        try {
            // 2.读取 XMl 文件,获取 docment 对象
            Document document = saxReader.read(new File("xml\\xml\\students.xml"));

            // 打印输出 org.dom4j.tree.DefaultDocument@58372a00 [Document: name file:///D:/Code/java_web/xml/xml/contacts.xml]
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
