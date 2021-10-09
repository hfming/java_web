package com.hfm.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-01 10:57
 * @Description 国际化类的使用
 * @date 2020/9/1
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        // 调用 ResourceBundle 静态方法 创建 ResourceBundle 对象
        // 使用 ResourceBundle 类加载资源包
        // 参数一：资源包的名称 默认直接指向类路径根目录
        // 参数二：国家 Local
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.UK);

        // 获取资源包中的数据
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String login = bundle.getString("login");
        System.out.println(username);
        System.out.println(password);
        System.out.println(login);
    }
}
