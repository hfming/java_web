package com.hfm.servlet.demo.daoimpl;

import com.hfm.servlet.demo.dao.ContactDAO;
import com.hfm.servlet.demo.entity.Contact;
import com.hfm.servlet.demo.util.ContactHandler;
import com.hfm.servlet.demo.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 22:29
 * @Description
 * @date 2020/8/13
 */
public class ContactDAOImpl implements ContactDAO {
    private String path = "D:\\Code\\java_web\\servlet\\web\\static\\xml\\Contacts.xml";
    private Document document = XMLManager.getDocument(path);
    private Element rootElement = document.getRootElement();

    /**
     * 添加联系人
     *
     * @param contact
     */
    @Override
    public void addContact(Contact contact) {
        // 添加 contact 标签
        Element element = rootElement.addElement("contact");

        // 设置 id 属性
        Element id = element.addAttribute("id", contact.getId());
        // contact 标签添加子标签
        Element name = element.addElement("name");
        Element gender = element.addElement("gender");
        Element age = element.addElement("age");
        Element email = element.addElement("email");
        Element phone = element.addElement("phone");
        Element address = element.addElement("address");

        // 设置标签文本
        name.setText(contact.getName());
        phone.setText(contact.getPhone());
        address.setText(contact.getAddress());
        gender.setText(contact.getGender());
        age.setText(contact.getAge() + "");
        email.setText(contact.getEmail());

        // 写回 XML 文件
        XMLManager.xmlWrite(document, path);
    }

    /**
     * 修改联系人
     *
     * @param contact
     * @param id
     */
    @Override
    public void updateContact(Contact contact, String id) {
        List<Element> elementList = rootElement.elements("contact");
        for (Element element : elementList) {
            if (id.equals(element.attributeValue("id"))) {
                // 修改标签文本与属性
                element.element("name").setText(contact.getName());
                element.element("phone").setText(contact.getPhone());
                element.element("address").setText(contact.getAddress());
                element.element("email").setText(contact.getEmail());
                element.element("age").setText(contact.getAge() + "");
                element.element("gender").setText(contact.getGender());
            }
        }
        // 写回 XML 文件
        XMLManager.xmlWrite(document, path);
    }

    /**
     * 删除联系人
     *
     * @param id
     * @return
     */
    @Override
    public void delectContact(String id) {
        List<Element> contacts = rootElement.elements("contact");
        for (Element contact : contacts) {
            if (id.equals(contact.attributeValue("id"))) {
                contact.detach();
                // 写回 XML 文件
                XMLManager.xmlWrite(document, path);
            }
        }
    }

    /**
     * 获取联系人集合
     *
     * @return
     */
    @Override
    public List<Contact> allContact() {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            ContactHandler contactHandler = new ContactHandler();
            saxParser.parse(new File(path), contactHandler);
            return contactHandler.getContacts();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过 ID 获取联系人
     *
     * @param id
     * @return
     */
    @Override
    public Contact findContactById(String id) {
        List<Element> elementList = rootElement.elements("contact");
        for (Element element : elementList) {
            if (id.equals(element.attributeValue("id"))) {
                Contact contact = new Contact();
                String name = element.elementText("name");
                String phone = element.elementText("phone");
                String address = element.elementText("address");
                String email = element.elementText("email");
                String age = element.elementText("age");
                String gender = element.elementText("gender");

                contact.setId(id);
                contact.setName(name);
                contact.setEmail(email);
                contact.setAddress(address);
                contact.setPhone(phone);
                contact.setGender(gender);
                contact.setAge((Integer.parseInt(age)));

                return contact;
            }
        }
        return null;
    }
}
