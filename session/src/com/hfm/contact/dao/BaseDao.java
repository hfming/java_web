package com.hfm.contact.dao;

import com.hfm.pojo.Product;
import com.hfm.contact.util.XMLManager;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 18:43
 * @Description Dao 父类
 * @date 2020/8/17
 */
public abstract class BaseDao {
    private String path = "D:\\Code\\java_web\\session\\web\\static\\xml\\Products.xml";
    private Document document = XMLManager.getDocument(path);
    private Element rootElement = document.getRootElement();

    /**
     * 通用查询语句
     * 泛型改造
     *
     * @return
     */
    public Product querySingle(String id) {
        List<Element> elements = rootElement.elements("Product");

        for (Element element : elements) {
            if (id.equalsIgnoreCase(element.attributeValue("id"))) {
                String name = element.element("name").getText();
                String type = element.element("type").getText();
                int price = Integer.parseInt(element.element("price").getText());
                Product product = new Product(id, name, price, type);
                return product;
            }
        }
        return null;
    }

    /**
     * 通用查询语句，返回多个对象
     *
     * @return
     */
    public List<Product> queryTable() {
        List<Element> elements = rootElement.elements("Product");
        // 创建集合存储封装好的对象
        ArrayList<Product> products = new ArrayList<>();

        for (Element element : elements) {
            String id = element.attributeValue("id");
            String name = element.element("name").getText();
            String type = element.element("type").getText();
            int price = Integer.parseInt(element.element("price").getText());
            Product product = new Product(id, name, price, type);
            products.add(product);
        }
        return products;
    }

    /**
     * 修改
     *
     * @return
     */
    public int change(Product product) {
        List<Element> elements = rootElement.elements("Product");

        for (Element element : elements) {
            if (product.getId().equalsIgnoreCase(element.attributeValue("id"))) {
                element.element("name").setText(product.getName());
                element.element("type").setText(product.getType());
                element.element("price").setText(product.getPrice() + "");
            }
        }
        XMLManager.xmlWrite(document, path);
        return 1;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Product remove(String id) {
        Product product = querySingle(id);
        List<Element> elements = rootElement.elements("Product");
        for (Element element : elements) {
            if (product.getId().equalsIgnoreCase(element.attributeValue("id"))) {
                // 删除 product 标签
                element.detach();
            }
        }
        XMLManager.xmlWrite(document, path);
        return product;
    }

    /**
     * 添加
     *
     * @param product
     */
    public void add(Product product) {
        Element addProduct = document.addElement("Product");
        // 添加子标签
        addProduct.addAttribute("id", product.getId());
        addProduct.addElement("name").setText(product.getName());
        addProduct.addElement("type").setText(product.getType());
        addProduct.addElement("price").setText(product.getPrice()+"");
        XMLManager.xmlWrite(document, path);
    }
}
