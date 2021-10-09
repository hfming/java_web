package com.hfm.contact.server.impl;

import com.hfm.contact.dao.ProductDao;
import com.hfm.contact.dao.impl.ProductDaoImpl;
import com.hfm.pojo.Product;
import com.hfm.contact.server.ProductServer;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 19:11
 * @Description 商品业务实现类
 * @date 2020/8/17
 */
public class ProductServerImpl implements ProductServer {
    /**
     * 创建 Product 数据库操作对象
     */
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getProducts() {
        List<Product> products = productDao.getProducts();
        return products;
    }

    @Override
    public Product getProductById(String id) {
        Product product = productDao.getProductById(id);
        return product;
    }

    @Override
    public Product removeProduct(String id) {
        Product product = productDao.removeProduct(id);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void changeProduct(Product product) {
        productDao.changeProduct(product);
    }
}
