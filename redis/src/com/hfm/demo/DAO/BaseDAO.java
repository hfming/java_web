package com.hfm.demo.DAO;

import com.hfm.demo.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-03 20:37
 */
public abstract class BaseDAO<T> {
    private Class<T> clazz = null;
    /**
     * 使用 JdbcTemplate 工具类
     */
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 自动获取 clazz 对象
     * 子类继承后，获取的clazz 对象就是子类泛型父类的泛型参数类class 对象
     */ {
        // 获取当前类的泛型父类
        Type genericSuperclass = this.getClass().getGenericSuperclass();

        // 强制数据类型转化
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        // 获取父类泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        // 获取泛型的第一个参数
        Type actualTypeArgument = actualTypeArguments[0];

        // 强制数据类型转化
        clazz = (Class<T>) actualTypeArgument;
    }

    /**
     * 通用查询语句
     * 泛型改造
     *
     * @param sql
     * @param args
     * @return
     */
    public T querySingle(String sql, Object... args) {
        return (T) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), args);
    }

    /**
     * 通用查询语句，返回多个对象
     *
     * @param sql
     * @param args
     * @return
     */
    public List<T> queryTable(String sql, Object... args) {
        return (List<T>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(clazz), args);
    }

    /**
     * 通用 增、删、改 方法
     *
     * @param sql
     * @param args
     * @return
     */
    public int change(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 查询一行一列数据通用方法
     *
     * @param sql
     * @param args
     */
    public Object getValue(String sql, Object... args) {
        return jdbcTemplate.queryForObject(sql, new SingleColumnRowMapper<>(), args);
    }
}
