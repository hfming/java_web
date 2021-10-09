package com.hfm.xpath;

import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 18:59
 * @Description XPath登录案例
 * 1）用户输入用户名和密码
 * 2）用用户名和密码到"数据库"中查找是否存在匹配对应的记录
 * 3）如果找到匹配的记录，那么就登录成功，否则登录失败。
 * @date 2020/8/7
 */
public class XPathDemo {
    public static void main(String[] args) {
        // 创建 document 对象
        Document document = XMLManager.getDocument("xml\\xml\\users.xml");

        // 字节输入
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Scanner scanner = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("=       用户登录系统       =");
        System.out.println("===========================");

        System.out.print("请输入姓名：");
        String name = scanner.next();

        System.out.print("请输入密码：");
        String passWord = scanner.next();

        String xpath = "//user[@name='" + name + "' and @password ='" + passWord + "' ]";
        Node node = document.selectSingleNode(xpath);
        if (node == null) {
            System.out.println("登录失败，用户名或密码输入错误！");
        }else{
            System.out.println(node);
        }
    }
}
