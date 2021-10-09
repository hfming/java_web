package com.hfm.dom;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-06 21:58
 * @Description 获取 XMl 标签的属性
 * @date 2020/8/6
 */
public class GetAttributes {
    public static void main(String[] args) {
        // 1.创建解析器
        SAXReader saxReader = new SAXReader();

        try {
            // 2.创建 document 对象
            Document document = saxReader.read("xml\\xml\\students.xml");

            // 3.读取根标签
            Element rootElement = document.getRootElement();

            // 4.更深层次的标签
            Element student = rootElement.element("student");

            // 5.读取属性
            // 获取属性必须先获取属性所在的标签
            Attribute id = student.attribute("id");
            System.out.println(id.getName());
            System.out.println(id.getData());
            System.out.println(id.getValue());

            // 直接获取指定属性名的属性值
            String idValue = student.attributeValue("id");
            System.out.println(idValue);

            // 获取所有属性
            List<Attribute> attributes = student.attributes();
            for (Attribute attribute : attributes) {
                System.out.println(attribute);
                System.out.println(attribute.getName());
                System.out.println(attribute.getData());
                System.out.println(attribute.getValue());
                System.out.println(attribute.getStringValue());
                System.out.println(attribute.getText());
                System.out.println(attribute.getQName());
            }

            // 获取第二个属性的属性值
            System.out.println(attributes.get(1).getName() + ":" + attributes.get(1).getValue());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
