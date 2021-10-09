package com.hfm.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-08 21:06
 * @Description jsoup 解析器入门
 * @date 2020/8/8
 */
public class JsoupFirst {
    public static void main(String[] args) throws IOException {
        // 1.获取 jsoup 解析器
        Document parse = Jsoup.parse(new File("xml\\xml\\contacts.xml"),"utf-8");
        //System.out.println(parse);

        // 2.获取元素
        Elements name = parse.getElementsByTag("name");
        for (Element element : name) {
            System.out.println(element.text());
        }
    }
}
