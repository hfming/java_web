package com.hfm.pojo;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 17:58
 * @Description 产品实体类
 * @date 2020/8/17
 */
public class Product {
    private String  id;
    private String name;
    private double price;
    private String type;

    /**
     * 无参构造函数
     */
    public Product() {
    }

    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param price
     * @param type
     */
    public Product(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product products = (Product) o;
        return id == products.id &&
                Double.compare(products.price, price) == 0 &&
                Objects.equals(name, products.name) &&
                Objects.equals(type, products.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Products{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
