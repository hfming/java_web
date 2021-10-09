package com.hfm.contact.server;

import com.hfm.pojo.Product;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 18:49
 * @Description 商品业务
 * @date 2020/8/17
 */
public interface ProductServer {
    /**
     * 查询所有的商品
     *
     * @return
     */
    List<Product> getProducts();

    /**
     * 通过 id 查询商品
     *
     * @param id
     * @return
     */
    Product getProductById(String id);

    /**
     * 通过 id 删除商品
     *
     * @param id
     * @return
     */
    Product removeProduct(String id);

    /**
     * 添加商品
     *
     * @param product
     */
    void addProduct(Product product);

    /**
     * 修改商品信息
     * @param product
     */
    void changeProduct(Product product);
}
