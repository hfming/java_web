package com.hfm.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfm.pojo.Person;
import com.hfm.pojo.PersonListTypeReference;
import com.hfm.pojo.PersonMapTypeReference;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-31 17:57
 * @Description
 * @date 2020/8/31
 */
public class JacksonTest {
    /**
     * java 对象转 JSON 字符串
     *
     * @throws JsonProcessingException
     */
    @Test
    public void javaToJson() throws IOException {
        // 创建java 对象
        Person person = new Person();
        person.setAge(23);
        person.setName("张三");
        person.setGender("男");

        // 创建 Jackson 核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // 转换java 对象到 JSON
        // objectMapper.writeValue(参数1，obj)
        // 参数1
        // File ：将 ojb 对象转换成 JSON 字符串，并保存到指定文件中
        // Write：将 ojb 对象转换成 JSON 字符串，并 将 JSON 数据填充到字符输流中
        // OutputStream：将 ojb 对象转换成 JSON 字符串，并 将 JSON 数据填充到字节输流中
        // objectMapper.writeValueAsString(obj)：将对象转换成 JSON 字符串

        String json = objectMapper.writeValueAsString(person);
        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);

        // json 字符串转 java 对象
        // 调用 objectMapper.readValue(json 字符串,class 对象) 将 JSON 字符串转换为 java 对象
        Person p = objectMapper.readValue(json, Person.class);
        System.out.println(p);
    }

    /**
     * java 对象数组转 JSON 字符串
     *
     * @throws JsonProcessingException
     */
    @Test
    public void javaArrayToJson() throws IOException {
        Person[] persons = {new Person("hfm", 24, "男"), new Person("ptt", 22, "女")};

        // 创建 Jackson 核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(persons);
        System.out.println(json);

        // JSON 字符串转 java 集合
        Object o = objectMapper.readValue(json, new PersonListTypeReference());
        System.out.println(o);
    }

    /**
     * java 对象集合转 JSON 字符串
     *
     * @throws JsonProcessingException
     */
    @Test
    public void javaListToJson() throws IOException {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("hfm", 24, "男"));
        persons.add(new Person("ptt", 22, "女"));

        // 创建 Jackson 核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(persons);
        System.out.println(json);

        // JSON 字符串转 java 集合
        Object o = objectMapper.readValue(json, new PersonListTypeReference());
        System.out.println(o);
    }

    /**
     * java Map 集合转 JSON 字符串
     * 单个对象
     *
     * @throws JsonProcessingException
     */
    @Test
    public void javaMapToJson() throws IOException {
        HashMap<String, Object> map = new HashMap<>();

        // 键值对要一一对应
        // 但是只能转换一个对象
        map.put("name", "ptt");
        map.put("age", 24);
        map.put("gender", "女");

        // 创建 Jackson 核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);
        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);

        // JSON 字符串转换为 java 对象
        Person p = objectMapper.readValue(json, Person.class);
        System.out.println(p);
    }

    /**
     * java Map 集合转 JSON 字符串
     * 多个对象
     *
     * @throws JsonProcessingException
     */
    @Test
    public void javaMapListToJson() throws IOException {
        HashMap<String, Object> map = new HashMap<>();

        map.put("hfm", new Person("hfm", 24, "男"));
        map.put("ptt", new Person("ptt", 22, "女"));

        // 创建 Jackson 核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);
        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);

        // JSON 字符串转换为 java Map 集合
        Object o = objectMapper.readValue(json, new PersonMapTypeReference());
        System.out.println(o);
    }

    /**
     * Jackson 注解
     *
     * @throws IOException
     */
    @Test
    public void annotionTest() throws IOException {
        Person person = new Person();
        person.setAge(23);
        person.setName("张三");
        person.setGender("男");
        person.setBirthday(new Date());
        person.setDeadDay(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        // 转换
        String json = objectMapper.writeValueAsString(person);
        // {"name":"张三","age":23,"gender":"男","deadDay":"2020-08-31"}
        System.out.println(json);
    }
}
