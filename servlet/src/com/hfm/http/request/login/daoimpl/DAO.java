package com.hfm.http.request.login.daoimpl;

import com.hfm.http.request.login.entity.User;
import com.hfm.http.request.login.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-03 20:37
 */
public abstract class DAO<T> {
    private Class<T> clazz = null;
    private QueryRunner queryRunner = new QueryRunner();

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
    public T querySingle(Connection connection, String sql, Object... args) {
        try {
            return (T) queryRunner.query(connection, sql, new BeanHandler<User>(User.class), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResources(connection, null);
        }
    }

    /**
     * 通用查询语句，返回多个对象
     *
     * @param sql
     * @param args
     * @return
     */
    public List<T> queryTable(Connection connection, String sql, Object... args) {
        try {
            return (List<T>) queryRunner.query(connection, sql, new BeanListHandler<User>(User.class), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResources(connection, null);
        }
    }

    /**
     * 通用 增、删、改 方法
     *
     * @param sql
     * @param args
     * @return
     */
    public int change(Connection connection, String sql, Object... args) {
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResources(connection, null);
        }
    }

    /**
     * 查询一行一列数据通用方法
     *
     * @param connection
     * @param sql
     * @param args
     */
    public <T> T getValue(Connection connection, String sql, Object... args) {
        try {
            return (T) queryRunner.query(connection, sql, new ScalarHandler(),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResources(connection, null);
        }
    }
}
