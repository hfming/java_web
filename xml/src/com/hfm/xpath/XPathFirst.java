package com.hfm.xpath;

import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Node;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 17:37
 * @Description XPath 入门
 * @date 2020/8/7
 */
public class XPathFirst {
    public static void main(String[] args) {
        Document document = XMLManager.getDocument("xml\\xml\\contacts.xml");

        // 查找 id 属性等于002的contact 标签
        String xpath = "//contact[@id=002]";

        Node node = document.selectSingleNode(xpath);
        System.out.println(node.getName());
    }
}
