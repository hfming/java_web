package com.hfm.sax;

import com.hfm.pojo.Contact;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 22:14
 * @Description
 * @date 2020/8/7
 */
public class GetObject {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1.使用 SAXParserFactory 工厂类对象，然后创建 SAXParser 对象
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        // 2.创建监听器子类
        ContactHandler contactHandler = new ContactHandler();

        // 3. SAX 解析 XML 文件
        saxParser.parse(new File("xml\\xml\\contacts.xml"), contactHandler);

        List<Contact> contacts = contactHandler.getContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
