package com.hfm.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hfm.pojo.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-01 16:12
 * @Description
 * @date 2020/9/1
 */
public class GsonTest {
    /**
     * java 对象转 JSON 字符串
     */
    @Test
    public void javaToJson() {
        // 创建对象
        Person hfm = new Person("hfm", 23, "17111711");

        // 创建 GJson 解析器
        Gson gson = new Gson();

        // 调用 gson 解析器的 toJson方法将java 对象转换为 JSON 字符串
        String s = gson.toJson(hfm);
        System.out.println(s);

        // JSON 字符串转 java 对象
        Person person = gson.fromJson(s, Person.class);
        System.out.println(person);
    }

    /**
     * 对象数组与 JSON 字符串相互转换
     */
    @Test
    public void javaArrayToJson() {
        Person[] persons = {new Person("hfm", 24, "男"), new Person("ptt", 22, "女")};

        // 创建 gson 解析器
        Gson gson = new Gson();

        // 调用 toJson 方法将 对象数组转化为 JSON 字符串
        String s = gson.toJson(persons);
        System.out.println(s);

        Object o = gson.fromJson(s, new PersonListType().getType());
        System.out.println(o);

        // 也可以使用 JackSon 的 TypeReference
        Object ps = gson.fromJson(s, new PersonListTypeReference().getType());
        System.out.println(ps);

        // 使用匿名内部类的形式
        Object p = gson.fromJson(s, new TypeToken<ArrayList<Person>>() {

        }.getType());
        System.out.println(p);
    }

    /**
     * java 集合转 JSON 字符串
     */
    @Test
    public void listToJSon() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("hfm", 24, "男"));
        persons.add(new Person("ptt", 22, "女"));

        // 创建 GJson 解析器
        Gson gson = new Gson();

        // 调用 gson 解析器的 toJson方法将java 对象转换为 JSON 字符串
        String s = gson.toJson(persons);
        System.out.println(s);

        // JSON 字符串转 java 集合
        ArrayList<Person> ps = gson.fromJson(s, new PersonListType().getType());
        System.out.println(ps);

        // 也可以使用 JackSon 的 TypeReference
        ArrayList<Person> o = gson.fromJson(s, new PersonListTypeReference().getType());
        System.out.println(o);

        // 使用匿名内部类的形式
        ArrayList<Person> p = gson.fromJson(s, new TypeToken<ArrayList<Person>>() {

        }.getType());
        System.out.println(p);
    }

    /**
     * java map 集合转 JSON 字符串
     * 一个对象
     */
    @Test
    public void mapToJSon() {
        HashMap<String, Object> map = new HashMap<>();

        // 键值对要一一对应
        // 但是只能转换一个对象
        map.put("name", "ptt");
        map.put("age", 24);
        map.put("gender", "女");

        // 创建 GJson 解析器
        Gson gson = new Gson();

        // 调用 gson 解析器的 toJson方法将java 对象转换为 JSON 字符串
        String s = gson.toJson(map);
        System.out.println(s);

        // JSON 转 java 对象
        Person p = gson.fromJson(s, Person.class);
        System.out.println(p);
    }

    /**
     * java map 集合转 JSON 字符串
     * 多个对象
     */
    @Test
    public void mapListToJSon() {
        HashMap<String, Object> map = new HashMap<>();

        map.put("hfm", new Person("hfm", 24, "男"));
        map.put("ptt", new Person("ptt", 22, "女"));

        // 创建 GJson 解析器
        Gson gson = new Gson();

        // 调用 gson 解析器的 toJson方法将java 对象转换为 JSON 字符串
        String s = gson.toJson(map);
        System.out.println(s);

        // JSON 转 java map 集合对象
        Map<String, Person> ps = gson.fromJson(s, new PersonMapType().getType());
        System.out.println(ps);

        // 也可以使用 JackSon 的 TypeReference
        Map<String, Person> o = gson.fromJson(s, new PersonMapTypeReference().getType());
        System.out.println(o);
    }
}
