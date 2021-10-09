package com.hfm.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import com.hfm.pojo.Contact;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-30 15:04
 * @Description
 * @date 2021/9/30
 */
public class JsoupObject {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.parse(new File("xml\\xml\\contacts.xml"), "utf-8");

            //根据document对象，创建JXDocument对象
            JXDocument jxDocument = new JXDocument(document);

            List<JXNode> contacts = jxDocument.selN("//contact");

            for (JXNode contactNode : contacts) {
                Element element = contactNode.getElement();
                String id = element.select("id").text();
                String name = element.select("name").text();
                String gender = element.select("gender").text();
                String phone = element.select("phone").text();
                String address = element.select("address").text();
                String qq = element.select("QQ").text();
                Contact contact = new Contact(id,name,phone,address,qq,gender);
                System.out.println(contact);
            }

        } catch (IOException | XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
