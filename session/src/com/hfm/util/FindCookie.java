package com.hfm.util;

import javax.servlet.http.Cookie;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-03 18:28
 * @Description
 * @date 2021/10/3
 */
public class FindCookie {
    public static Cookie findCookie(String cookieName, Cookie[] cookies) {
        if (cookies == null || cookies.length == 0 || cookieName == null || "".equalsIgnoreCase(cookieName.trim())) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookieName.equalsIgnoreCase(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
