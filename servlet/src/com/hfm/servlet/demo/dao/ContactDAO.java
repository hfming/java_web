package com.hfm.servlet.demo.dao;

import com.hfm.servlet.demo.entity.Contact;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-13 22:16
 * @Description DAO 接口
 * 一个实体对象对应一个 DAO 接口
 * @date 2020/8/13
 */
public interface ContactDAO {
    /**
     * 添加联系人
     *
     * @param contact
     */
    void addContact(Contact contact);

    /**
     * 修改联系人
     *
     * @param contact
     */
    void updateContact(Contact contact,String id);

    /**
     * 删除联系人
     *
     * @param id
     */
    void delectContact(String id);

    /**
     * 查询所有联系人
     *
     * @return
     */
    List<Contact> allContact();

    /**
     * 根据ID 查询指定联系人
     *
     * @param id
     * @return
     */
    Contact findContactById(String id);
}
