package com.hfm.dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-06 19:38
 * @Description 读取 XML 中的标签
 * @date 2020/8/6
 */
public class GetTags {
    public static void main(String[] args) {
        // 1.创建 SaxReader 解析器
        SAXReader saxReader = new SAXReader();

        File file = new File("xml\\xml\\students.xml");
        try {
            // 2.创建 document 对象
            Document document = saxReader.read(file);

            // 3.读取标签
            // 根标签
            Element rootElement = document.getRootElement();
            System.out.println(rootElement);

            // 获取名称
            System.out.println(rootElement.getName());
            // System.out.println(rootElement.getData());
            System.out.println("==============");

            // 获取子节点 element("子节点名称") 获取一个子节点
            Element student = rootElement.element("student");
            System.out.println(student);
            System.out.println(student.getName());
            System.out.println("==============");

            // 获取所有子节点 集合
            List<Element> elements = rootElement.elements();
            elements.forEach(System.out::println);
            System.out.println("==============");

            // 根据标签名获取特定子节点集合
            List<Element> students = rootElement.elements("student");
            students.forEach(System.out::println);
            System.out.println("==============");

            System.out.println("集合遍历方式回顾");
            // 4. 集合遍历方式回顾
            extracted(students);

            // 获取更深层次的标签 通过已经获取的节点获取其子节点，方法与上面的相同
            Element name = student.element("name");
            System.out.println(name);
            // 获取值
            Object nameData = name.getData();
            System.out.println(nameData);

            Element age = student.element("age");
            System.out.println(age);
            Object ageData = age.getData();
            System.out.println(ageData);

            // 可以通过链式编程一步获取更深层次的标签
            Element name2 = document.getRootElement().element("student").element("name");
            System.out.println(name2.getData());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void extracted(List<Element> students) {
        // 4.1.for 循环
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("==============");

        // 4.2.迭代器遍历
        Iterator<Element> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==============");

        // 4.3.for-each 遍历其实也是依靠迭代器进行遍历
        for (Element element : students) {
            System.out.println(element);
        }
        System.out.println("==============");

        // 4.4.foreach 方法 + 拉姆达表达式
        students.forEach(System.out::println);
        System.out.println("==============");

        // 4.4.迭代器的 forEachRemaining
        iterator.forEachRemaining(System.out::println);
        System.out.println("==============");

        // 4.5.Stream API 进行遍历
        students.stream().forEach(System.out::println);
        System.out.println("==============");
    }
}
