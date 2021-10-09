package com.hfm.demo.pojo;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:01
 * @Description 省份实体
 * @date 2020/9/8
 */
public class Province {
    private int id;
    private String name;

    public Province() {
    }

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Province{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Province province = (Province) o;
        return id == province.id &&
                Objects.equals(name, province.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
