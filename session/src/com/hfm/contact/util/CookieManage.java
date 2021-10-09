package com.hfm.contact.util;

import javax.servlet.http.Cookie;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-18 17:48
 * @Description Cookie 工具类
 * @date 2020/8/18
 */
public class CookieManage {
    /**
     * 通过名称获取 Cookie 对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie getCookieByName(String name , Cookie[] cookies){
        // 如果 cookies 数组为空
        if (cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equalsIgnoreCase(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
