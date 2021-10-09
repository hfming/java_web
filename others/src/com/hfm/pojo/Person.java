package com.hfm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-31 17:55
 * @Description
 * @date 2020/8/31
 */
public class Person {
    private String name;
    private int age;
    private String gender;
    /**
     * 排除属性
     */
    @JsonIgnore
    private Date birthday;
    /**
     * 属性值得格式化
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadDay;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDeadDay() {
        return deadDay;
    }

    public void setDeadDay(Date deadDay) {
        this.deadDay = deadDay;
    }

    public Person() {
    }


    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", deadDay=").append(deadDay);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
