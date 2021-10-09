package com.hfm.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-28 16:24
 * @Description 参数转换工具类
 * @date 2020/8/28
 */
public class ParamsUtils {
    /**
     * 表单参数创建对象
     *
     * @param httpServletRequest
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getParamsToBean(HttpServletRequest httpServletRequest, Class<T> clazz) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        T o;
        try {
            // 创建对象
            o = clazz.newInstance();
            // 通过 BeanUtils 工具类对对象属性进行赋值
            BeanUtils.populate(o, parameterMap);
            return o;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将 map 中的参数放入 JavaBean 中
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getMapToBean(Map parameterMap, Class<T> clazz) {
        T o;
        try {
            // 创建对象
            o = clazz.newInstance();
            // 通过 BeanUtils 工具类对对象属性进行赋值
            BeanUtils.populate(o, parameterMap);
            return o;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 参数转换
     * 将 String 转换成 int 数据类型，进进行错误错误处理
     *
     * @param string
     * @param defaultValue
     * @return
     */
    public static int parseInt(String string, int defaultValue) {
        int i = defaultValue;
        try {
            // 去除 null 与空串
            if (string != null && !"".equalsIgnoreCase(string.trim()) && !"null".equalsIgnoreCase(string.trim())) {
                i = Integer.parseInt(string);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return i;
        }
    }
}
