package com.hfm.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-08 21:26
 * @Description
 * @date 2020/8/8
 */
public class JsoupCoreAPI {
    public static void main(String[] args) throws IOException {
        // jsoup 对象
        Document document = Jsoup.parse(new File("xml\\xml\\contacts.xml"), "utf-8");

        // 解析 url
        Document document1 = Jsoup.parse(new URL("https://www.bilibili.com/video/BV1v54y1m7WJ"),10000);
        System.out.println(document1);

        String html = "<html>\n" +
                "\n" +
                "\t<head>\n" +
                "\t\t<title>传智播客5月28号班通讯录</title>\n" +
                "\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n" +
                "\t</head>\n" +
                "\n" +
                "\t<body>\n" +
                "\t\t<center>\n" +
                "\t\t\t<h1>传智播客5月28号班通讯录</h1>\n" +
                "\t\t</center>\n" +
                "\t\t<table border=\"1\" align=\"center\" id=\"contactForm\">\n" +
                "\t\t\t<thead>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th>编号</th>\n" +
                "\t\t\t\t\t<th>姓名</th>\n" +
                "\t\t\t\t\t<th>性别</th>\n" +
                "\t\t\t\t\t<th>年龄</th>\n" +
                "\t\t\t\t\t<th>地址</th>\n" +
                "\t\t\t\t\t<th>电话</th>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</thead>\n" +
                "\t\t\t<tbody>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>001</td>\n" +
                "\t\t\t\t\t<td>张三</td>\n" +
                "\t\t\t\t\t<td>男</td>\n" +
                "\t\t\t\t\t<td>18</td>\n" +
                "\t\t\t\t\t<td>广州市天河区</td>\n" +
                "\t\t\t\t\t<td>134000000000</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</tbody>\n" +
                "\t\t</table>\n" +
                "\t</body>\n" +
                "\n" +
                "</html>";
        // 解析 html
        Document document2 = Jsoup.parse(html);

        // document 对象
        Element name = document.getElementById("name");

        // 通过标签名获取
        Elements names = document.getElementsByTag("name");

        // 通过 属性获取
        Elements id = document.getElementsByAttribute("id");

        // 指定属性值的元素
        Elements id1 = document.getElementsByAttributeValue("id", "001");

        System.out.println("====================");
        // element 对象
        Element firstName = document.getElementsByTag("contact").get(0);
        // 元素的文本
        System.out.println(firstName.text());
        System.out.println("====================");
        // 获取标签体的所有内容(包括字标签的字符串内容)
        System.out.println(firstName.html());
        System.out.println("====================");
        // 根据属性名称获取属性值
        System.out.println(firstName.attr("id"));
        System.out.println(firstName.val());
        System.out.println("====================");
    }
}
