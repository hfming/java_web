package com.hfm.xpath;

import com.hfm.pojo.Person;
import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 20:11
 * @Description DOM4J 解析 HTML 文档
 * @date 2020/8/7
 */
public class DOM4JHtml {
    public static void main(String[] args) {
        // 获取 document 对象
        Document document = XMLManager.getDocument("xml\\xml\\persons.html");

        String xpath = "//tbody/tr";

        List<Node> nodes = document.selectNodes(xpath);

        // 创建集合用于存储用户
        ArrayList<Person> persons = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++) {
            List<Node> tds = document.selectNodes("//tbody/tr[" + (i + 1) + "]/td");
            persons.add(new Person(tds.get(0).getText(), tds.get(1).getText(), tds.get(2).getText(), Integer.parseInt(tds.get(3).getText()), tds.get(4).getText(), tds.get(5).getText()));
        }

        System.out.println(persons.size());
        System.out.println(persons);
    }
}
