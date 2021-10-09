package com.hfm.contact.dao.impl;

import com.hfm.pojo.User;
import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 23:45
 * @Description
 * @date 2020/8/17
 */
public class UserDaoImpl {
    private String path = "D:\\Code\\java_web\\session\\web\\static\\xml\\Users.xml";
    private Document document = XMLManager.getDocument(path);
    private Element rootElement = document.getRootElement();

    /**
     * 通过 id 获取对象
     *
     * @param id
     * @return
     */
    public User findById(String id) {
        // 查找是否存在 name 标签为指定内容的标签
        String xpath = "/user[@id= '" + id + "']";

        Element element = (Element) rootElement.selectSingleNode(xpath);
        if (element == null) {
            return null;
        } else {
            User user = new User();
            user.setId(element.attributeValue("id"));
            user.setName(element.elementText("name"));
            user.setPassword(element.elementText("password"));
            return user;
        }
    }

    /**
     * 通过名字查找对象
     *
     * @param name
     * @return
     */
    public User findByName(String name) {
        // 查找是否存在 name 标签为指定内容的标签
        String xpath = "//name[text() ='" + name + "']";

        Element element = (Element) rootElement.selectSingleNode(xpath);
        if (element == null) {
            return null;
        } else {
            Element parent = element.getParent();
            User user = new User();
            user.setId(parent.attributeValue("id"));
            user.setName(parent.elementText("name"));
            user.setPassword(parent.elementText("password"));
            return user;
        }
    }

    /**
     * 是否存在用户名
     *
     * @param name
     * @return
     */
    public boolean checkName(String name) {
        if (findByName(name) == null) {
            return false;
        } else {
            return true;
        }
    }
}
