package com.hfm.xpath;

import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 17:51
 * @Description XPath 表达式
 * @date 2020/8/7
 */
public class XPathExpression {
    public static void main(String[] args) {
        // 获取 documnet 对象
        Document document = XMLManager.getDocument("xml\\xml\\contacts.xml");

        // / 绝对路径 表示 XML 文档根标签起始
        String xpath = "/contacts/contact";
        List<Node> nodes = document.selectNodes(xpath);
        System.out.println(nodes.size());

        // // 相对路径
        xpath = "//contact";
        List<Node> nodes1 = document.selectNodes(xpath);
        System.out.println(nodes1.size());

        // 一起使用
        xpath = "//contact/name";
        List<Node> nodes3 = document.selectNodes(xpath);
        System.out.println(nodes3.size());
        System.out.println(nodes3.get(0).getName());

        // * 通配符
        xpath = "/*/*";
        List<Node> nodes2 = document.selectNodes(xpath);
        System.out.println(nodes2.size());
        System.out.println(nodes2.get(0).getName());
        System.out.println("===========================");

        // [] 条件判断
        // @ 属性
        xpath = "//contact[id]";
        Node node = document.selectSingleNode(xpath);
        System.out.println(node);
        System.out.println(node.getPath());

        xpath = "//contact[id='002']";
        Node node1 = document.selectSingleNode(xpath);
        System.out.println(node1.getName());
        System.out.println("===========================");

        // 第一个
        xpath = "contact[1]";

        // 最后一个
        xpath = "contact[last()]";

        // 第一个 name 标签的文本
        xpath = "//contact[1]/name/text()";
        Node node2 = document.selectSingleNode(xpath);
        System.out.println(node2.getText());

        // 查找文本指定文本内容的标签
        xpath = "//contact/name[text() ='刘备']";
    }
}
