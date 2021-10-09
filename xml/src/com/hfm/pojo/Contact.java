package com.hfm.pojo;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-06 22:44
 * @Description 联系人实体
 * @date 2020/8/6
 */
public class Contact {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String qq;
    private String gender;

    /**
     * 无参构造函数
     */
    public Contact() {
    }

    /**
     * 全参构造函数
     * @param id
     * @param name
     * @param phone
     * @param address
     * @param qq
     */
    public Contact(String id, String name, String phone, String address, String qq,String gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.qq = qq;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(phone, contact.phone) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(qq, contact.qq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, address, qq);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
