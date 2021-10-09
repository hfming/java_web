package com.hfm.dom;

import com.hfm.pojo.Contact;
import com.hfm.contact.util.XMLManager;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 10:29
 * @Description XMl 封装成对象
 * @date 2020/8/7
 */
public class GetObject {
    public static void main(String[] args) {
        // 获取根节点
        Element rootElement = XMLManager.getRootElement("xml\\xml\\contacts.xml");

        List<Element> contactList = rootElement.elements("contact");
        // 创建集合存储封装好的对象
        ArrayList<Contact> contacts = new ArrayList<>();

        for (Element element : contactList) {
            String id = element.element("id").getText();
            String name = element.element("name").getText();
            String phone = element.element("phone").getText();
            String address = element.element("address").getText();
            String qq = element.element("QQ").getText();
            String gender = element.element("gender").getText();
            Contact contact = new Contact(id, name, phone, address, qq, gender);
            contacts.add(contact);
        }
        System.out.println(contacts);
    }
}
