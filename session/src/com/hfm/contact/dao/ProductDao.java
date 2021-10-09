package com.hfm.contact.dao;

import com.hfm.pojo.Product;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 18:35
 * @Description Product 增删改接口
 * @date 2020/8/17
 */
public interface ProductDao {
    /**
     * 添加商品
     *
     * @param product
     */
    void addProduct(Product product);

    /**
     * 删除商品
     *
     * @param id
     */
    Product removeProduct(String id);

    /**
     * 修改商品
     *
     * @param product
     */
    void changeProduct(Product product);

    /**
     * 通过 id 查询商品
     *
     * @param id
     * @return
     */
    Product getProductById(String id);

    /**
     * 获取所有商品
     *
     * @return
     */
    List<Product> getProducts();
}
