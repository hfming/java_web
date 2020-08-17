package com.hfm.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-16 16:29
 * @Description JDBC 工具类
 * @date 2020/8/16
 */
public class JDBCUtils {
    private static DruidDataSource dataSource;

    public static DruidDataSource getDataSource() {
        return dataSource;
    }

    static {
        try {
            // 1. 通过反射加载 properties 配置文件
//            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//            InputStream resourceAsStream = systemClassLoader.getResourceAsStream("druid.properties");

            FileInputStream resourceAsStream = new FileInputStream("D:\\Code\\java_web\\book\\src\\druid.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            // 通过工厂类创建数据库连接池对象
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
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
