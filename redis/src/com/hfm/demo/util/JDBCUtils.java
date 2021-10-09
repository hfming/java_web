package com.hfm.demo.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
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
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    static {
        try {
            // 1. 通过反射加载 properties 配置文件
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
     * 用于存储当前线程共享的数据库连接对象
     */
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    /**
     * 使用 Druid 数据库连接池，创建数据库连接对象
     *
     * @return 数据库连接对象
     */
    public static Connection getConnectionByDruid() {
        try {
            Connection connection = conns.get();
            if (connection == null) {
                 connection = dataSource.getConnection();
            }
            // 手动开启线程
            connection.setAutoCommit(false);
            // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
            conns.set(connection);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose() {
        Connection conection = conns.get();
        // 如果不等于 nul，说明 之前使用过连接，操作过数据库
        if (conection != null) {
            try {
                // 提交事务
                conection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接，资源资源
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose() {
        Connection conection = conns.get();
        // 如果不等于 null，说明 之前使用过连接，操作过数据库
        if (conection != null) {
            try {
                //回滚事务
                conection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接，资源资源
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 关闭资源
     *
     * @param connection        数据库连接对象
     * @param preparedStatement 预编译对象
     */
    public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 重载，关闭资源,用于关闭 query 查询操作
     *
     * @param connection        数据库连接对象
     * @param preparedStatement 预编译对象
     * @param resultSet         查询结果集
     */
    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
