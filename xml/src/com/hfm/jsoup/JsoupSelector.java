package com.hfm.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import java.io.File;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-08 22:13
 * @Description jsoup selector 选择器
 * @date 2020/8/8
 */
public class JsoupSelector {
    public static void main(String[] args) {
        // 1.获取 documnet 对象
        try {
            Document document = Jsoup.parse(new File("xml\\xml\\contacts.xml"), "utf-8");

            String query = "name";
            // 2.创建选择器对象,通过选择器 select 方法获取 elements 集合
            Elements select = Selector.select(query, document);
            System.out.println(select);
            System.out.println("======================");

            // 或者调用 document.select("css 选择器");
            // 元素选择器/标签选择器
            Elements name = document.select("name");
            System.out.println(name);
            System.out.println("======================");
            // id 选择器
            Elements select1 = document.select("#002");
            System.out.println(select1);
            System.out.println("======================");
            Elements select2 = document.select("contact[id='002']");
            System.out.println(select2);

            // 选择器的用法与 CSS 选取完全相同
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
