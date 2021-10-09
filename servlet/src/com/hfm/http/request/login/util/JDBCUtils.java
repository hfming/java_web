package com.hfm.http.request.login.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description JDBCUtils 最终版
 * 使用了 3种数据库连接池与 DbUtils 工具类
 * @date 2020-06-04 21:31
 */
public class JDBCUtils {
//    private static ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0-config");

    /**
     * 使用 C3p0 数据库连接池，获取连接对象
     *
     * @return 数据库连接对象
     */
//    public static Connection getConnectionByC3P0() {
//        try {
//            // 1.创建数据库连接池对象，读取XML 文件信息  <named-config name="c3p0-config">
//            return cpds.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static DataSource dataSource;

//    public static ComboPooledDataSource getCpds() {
//        return cpds;
//    }

    public static DataSource getDataSource() {
        return dataSource;
    }

//    /**
//     * DBCP 初始化
//     */
//    static {
//        try {
//            // 1. 通过反射加载 properties 配置文件
//            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//            InputStream resourceAsStream = systemClassLoader.getResourceAsStream("dbcp.properties");
//
//            Properties properties = new Properties();
//            properties.load(resourceAsStream);
//
//            dataSource = BasicDataSourceFactory.createDataSource(properties);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     * 使用 DBCP  创建数据库连接池
     * 通过 BasicDataSourceFactory 工厂类加载 properties 配置文件创建数据库连接池
     *
     * @return 数据库连接对象
     */
//    public static Connection getConnectionByDBCP() {
//        try {
//            return dataSource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    static {
        try {
            // 1. 通过反射加载 properties 配置文件
            // ClassLoader 只能获取 src 下的不能获取 web 目录下的文件
            ClassLoader systemClassLoader = JDBCUtils.class.getClassLoader();
            InputStream resourceAsStream = systemClassLoader.getResourceAsStream("druid.properties");

            Properties properties = new Properties();
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用 Druid 数据库连接池，创建数据库连接对象
     *
     * @return 数据库连接对象
     */
    public static Connection getConnectionByDruid() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭资源
     *
     * @param connection        数据库连接对象
     * @param preparedStatement 预编译对象
     */
    public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
        // 使用 DbUtils 关闭资源
        DbUtils.closeQuietly(connection);
        DbUtils.closeQuietly(preparedStatement);
    }

    /**
     * 重载，关闭资源,用于关闭 query 查询操作
     *
     * @param connection        数据库连接对象
     * @param preparedStatement 预编译对象
     * @param resultSet         查询结果集
     */
    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        // 使用 DbUtils 关闭资源
        DbUtils.closeQuietly(connection);
        DbUtils.closeQuietly(preparedStatement);
        DbUtils.closeQuietly(resultSet);
    }
}
