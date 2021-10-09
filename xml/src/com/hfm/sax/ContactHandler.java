package com.hfm.sax;

import com.hfm.pojo.Contact;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 22:16
 * @Description
 * @date 2020/8/7
 */
public class ContactHandler extends DefaultHandler {
    /**
     * 存储Contact对象
     */
    private List<com.hfm.pojo.Contact> contacts = new ArrayList<Contact>();
    private Contact contact = null;
    private String lastTag;

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.lastTag = qName;
        if ("contact".equalsIgnoreCase(qName)) {
            contact = new Contact();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if ("id".equalsIgnoreCase(this.lastTag)) {
            contact.setId(content);
        }
        if ("name".equalsIgnoreCase(this.lastTag)) {
            contact.setName(content);
        }
        if ("phone".equalsIgnoreCase(this.lastTag)) {
            contact.setPhone(content);
        }
        if ("qq".equalsIgnoreCase(this.lastTag)) {
            contact.setQq(content);
        }
        if ("gender".equalsIgnoreCase(this.lastTag)) {
            contact.setGender(content);
        }
        if ("adderss".equalsIgnoreCase(this.lastTag)) {
            contact.setAddress(content);
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
