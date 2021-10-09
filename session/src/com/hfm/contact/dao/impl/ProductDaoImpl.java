package com.hfm.contact.dao.impl;

import com.hfm.contact.dao.BaseDao;
import com.hfm.contact.dao.ProductDao;
import com.hfm.pojo.Product;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 18:45
 * @Description 数据库增删查改实现类
 * 数据持久化操作
 * @date 2020/8/17
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public void addProduct(Product product) {
        add(product);
    }

    @Override
    public Product removeProduct(String id) {
        Product remove = remove(id);
        return remove;
    }

    @Override
    public void changeProduct(Product product) {
        change(product);
    }

    @Override
    public Product getProductById(String id) {
        return querySingle(id);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = queryTable();
        return products;
    }
}
