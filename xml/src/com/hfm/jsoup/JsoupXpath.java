package com.hfm.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-08 22:33
 * @Description jsoup 与 Xpath 一起使用
 * @date 2020/8/8
 */
public class JsoupXpath {
    public static void main(String[] args) {
        // 1.获取 document 对象
        try {
            Document document = Jsoup.parse(new File("xml\\xml\\contacts.xml"), "utf-8");

            //3.根据document对象，创建JXDocument对象
            JXDocument jxDocument = new JXDocument(document);

            //4.结合xpath语法查询
            //4.1查询所有student标签
            List<JXNode> jxNodes = jxDocument.selN("//contact");
            for (JXNode jxNode : jxNodes) {
                System.out.println(jxNode);
            }
            System.out.println("--------------------");

            //4.2查询所有student标签下的name标签
            List<JXNode> jxNodes2 = jxDocument.selN("//contact/name");
            for (JXNode jxNode : jxNodes2) {
                System.out.println(jxNode);
            }
            System.out.println("--------------------");

            //4.3查询student标签下带有id属性的name标签
            List<JXNode> jxNodes3 = jxDocument.selN("//contact[@id]");
            for (JXNode jxNode : jxNodes3) {
                System.out.println(jxNode);
            }
            System.out.println("--------------------");

            //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
            List<JXNode> jxNodes4 = jxDocument.selN("//contact[@id='001']");
            for (JXNode jxNode : jxNodes4) {
                System.out.println(jxNode);
            }
        } catch (IOException | XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
