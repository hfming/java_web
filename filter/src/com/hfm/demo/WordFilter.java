package com.hfm.demo;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-29 20:30
 * @Description 敏感词过滤器
 * @date 2020/8/29
 */
//@WebFilter(filterName = "WordFilter", urlPatterns = {"/users", "/add.jsp", "/update.jsp", "/words"})
public class WordFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("敏感词过滤器 - 销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 创建代理类对象 - 动态代理
        // 其他获取参数的方法也需要进行增强
        ServletRequest requestPro = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), (proxy, method, args) -> {
            // 增强 getParameter 方法
            if ("getParameter".equalsIgnoreCase(method.getName())) {
                // 获取返回值
                String parma = (String) method.invoke(req, args);
                // 参数非空，非空字符串
                if(parma != null && !"".equalsIgnoreCase(parma.trim())){
                    // 敏感此过滤替换
                    for (String word : words) {
                        // 并且包含敏感词则进行替换
                        if (parma.contains(word)) {
                            parma = parma.replaceAll(word, "***");
                        }
                    }
                }
                // 返回结果
                return parma;
            }
            // 如果不是 getParameter 方法原样返回
            return method.invoke(req, args);
        });
        System.out.println(requestPro.getParameter("name"));
        System.out.println(req.getParameter("name"));

        System.out.println("敏感词过滤器 - 执行前");
        chain.doFilter(requestPro, resp);
        System.out.println("敏感词过滤器 - 执行后");
    }

    private List<String> words = new ArrayList<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("敏感词过滤器 - 启动");
        BufferedReader bufferedReader = null;
        try {
//        // 获取真实路径(不推荐)
//        String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/sensitiveword.txt");

            // 加载资源文件，默认路径为 src 路径，发布到 web 中变成 /WEB-INF/classes路径
            ClassLoader classLoader = WordFilter.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("sensitiveword.txt");

            bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String content;
            // 将每一行添加到集合中
            while ((content = bufferedReader.readLine()) != null) {
                words.add(content);
            }

            System.out.println("敏感词：" + words);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
