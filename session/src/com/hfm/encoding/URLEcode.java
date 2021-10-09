package com.hfm.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 15:40
 * @Description
 * @date 2020/8/17
 */
public class URLEcode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中文";

        // Http 传输数据默认使用 URLEncoder 进行加密
        // 加密
        str = URLEncoder.encode(str, "utf-8");
        System.out.println(str);

        // 解密
        str = URLDecoder.decode(str, "utf-8");
        System.out.println(str);
    }
}
