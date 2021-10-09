package com.hfm.dom;

import com.hfm.pojo.Contact;
import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 9:20
 * @Description
 * @date 2020/8/7
 */
public class XMLCRUD {
    private static Document document = XMLManager.getDocument("xml\\xml\\contacts.xml");
    private static Element rootElement = document.getRootElement();

    public static void main(String[] args) throws IOException {

        // 创建 contact 对象
        Contact contact = new Contact("004", "花容", "13756649324", "青风寨", "66245398", "男");

        // 添加对象
//        addContact(contact);

        // 修改 XML 文件
//        editContact(contact, "001");

        // 删除子标签
        removeContact("001");

        FileOutputStream fileOutputStream = new FileOutputStream("xml\\xml\\contactsOut.xml");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        // 漂亮的格式
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        // 紧凑的格式，更省空间
        OutputFormat compactFormat = OutputFormat.createCompactFormat();

        // 设置编码格式
        // 1.可以影响 XML 文档声明的 encoding 编码
        // 2.还可以影响 XML 文件保存的编码
        prettyPrint.setEncoding("utf-8");

        // 创建 XMLWriter 对象，XMLWriter 对象没有写出数据的功能需要借助输出流 fileOutputStream
        XMLWriter xmlWriter = new XMLWriter(bufferedOutputStream, prettyPrint);
        xmlWriter.write(document);
        xmlWriter.close();
    }

    /**
     * 添加
     */
    private static void addContact(Contact contact) {
        // 添加 contact 标签
        Element element = rootElement.addElement("contact");
        // contact 标签添加子标签
        Element id = element.addElement("id");
        Element name = element.addElement("name");
        Element phone = element.addElement("phone");
        Element address = element.addElement("address");
        Element qq = element.addElement("QQ");

        // 设置标签文本
        id.setText(contact.getId());
        name.setText(contact.getName());
        phone.setText(contact.getPhone());
        address.setText(contact.getAddress());
        qq.setText(contact.getQq());
    }

    /**
     * 修改
     */
    private static void editContact(Contact contact, String id) {
        List<Element> elementList = rootElement.elements("contact");
        for (Element element : elementList) {
            if (id.equals(element.elementText("id"))) {
                // 修改标签文本与属性
                element.addAttribute("id", contact.getId());
//                element.element("id").setText(contact.getId());
//                element.element("name").setText(contact.getName());
                element.element("phone").setText(contact.getPhone());
                element.element("address").setText(contact.getAddress());
                element.element("QQ").setText(contact.getQq());
            }
        }
    }

    /**
     * 删除元素
     *
     * @param id
     */
    private static Element removeContact(String id) {
        List<Element> contacts = rootElement.elements("contact");
        for (Element contact : contacts) {
            if (id.equals(contact.elementText("id"))) {
                rootElement.remove(contact);
                // 删除自己
                // contact.detach();
                return contact;
            }
        }
        return null;
    }

    /**
     * 删除元素
     *
     * @param id
     */
    private static Element removeContactByAttrId(String id) {
        List<Element> contacts = rootElement.elements("contact");
        for (Element contact : contacts) {
            if (id.equals(contact.attributeValue("id"))) {
                rootElement.remove(contact);
                // 删除自己
                // contact.detach();
                return contact;
            }
        }
        return null;
    }
}
