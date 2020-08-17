package com.hfm.servlet.demo.util;

import com.hfm.servlet.demo.entity.Contact;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 22:16
 * @Description Sax 解析监听器
 * @date 2020/8/7
 */
public class ContactHandler extends DefaultHandler {
    /**
     * 存储Contact对象
     */
    private List<Contact> contacts = new ArrayList<Contact>();
    private Contact contact = null;
    private String lastTag;

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.lastTag = qName;
        if ("contact".equalsIgnoreCase(qName)) {
            String id = attributes.getValue("id");
            contact = new Contact();
            contact.setId(id);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if ("name".equalsIgnoreCase(this.lastTag)) {
            contact.setName(content);
        }
        if ("phone".equalsIgnoreCase(this.lastTag)) {
            contact.setPhone(content);
        }
        if ("gender".equalsIgnoreCase(this.lastTag)) {
            contact.setGender(content);
        }
        if ("address".equalsIgnoreCase(this.lastTag)) {
            contact.setAddress(content);
        }
        if ("email".equalsIgnoreCase(this.lastTag)) {
            contact.setEmail(content);
        }
        if ("age".equalsIgnoreCase(this.lastTag)) {
            contact.setAge(Integer.parseInt(content));
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("contact".equalsIgnoreCase(qName)) {
            contacts.add(contact);
        }
        this.lastTag = null;
    }
}
