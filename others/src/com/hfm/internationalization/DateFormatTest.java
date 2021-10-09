package com.hfm.internationalization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-01 11:52
 * @Description 日期与时间格式化
 * @date 2020/9/1
 */
public class DateFormatTest {
    public static void main(String[] args) {
        // 使用 DateFormat 静态方法 getDateTimeInstance 创建时间与日期格式化对象
        // 参数一：日期格式 short medium full
        // 参数二：时间格式 short medium full
        // 参数三：国家 locale
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.UK);

        String format = dateFormat.format(new Date());
        System.out.println(format);
    }
}
