package com.hfm.http.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-12 17:05
 * @Description 获取表单输入参数
 * @date 2020/8/12
 */
@WebServlet(name = "GetParamenter", urlPatterns = "/getParamenter")
public class GetParamenter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 该方法只能对 post 方法有效，此方法只能设置对请求的实体内容解码查询时的码表。
        // post 参数提交时放在实体内容中，因此只对 post 方式有效
        // 而 get 方式提交时参数放在 URI 后面，因此 get方式无效
        request.setCharacterEncoding("utf-8");

        // post 获取表单参数方式
        // post 方式参数在实体内容中
        // 提交的表单必须要有 name 属性,才能获取其参数值
        ServletInputStream inputStream = request.getInputStream();
        int length;
        byte[] bytes = new byte[1024 << 4];
        while ((length = inputStream.read(bytes)) != -1) {
            String str = new String(bytes, 0, length);
            // username=hfm&password=17111711&email=hfming2016%40163.com&name=huang+fuming&phone=13758860183&gender=boy&vCode=jgmkj
            System.out.println(str);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get 方式不能使用 request.setCharacterEncoding 方法设置码表
        // get 方式需要手动解码
        String name = request.getParameter("username");

        if("GET".equals(request.getMethod())){
            // 重新解码
//            name = new String(name.getBytes("iso-8859-1"),"utf-8");
            name = new String(name.getBytes("utf-8"),"utf-8");
        }
        System.out.println(name);

        // get 获取表单参数方式
        // 获取参数字符串
        String queryString = request.getQueryString();
        // username=hfm&password=17111711&email=hfming2016%40163.com&name=huang+fuming&phone=13758860183&gender=boy&vCode=jgmkj
        System.out.println(queryString);
        System.out.println("========================");

        // 出现的问题：
        // 1.获取到参数数据需要进一步切割处理
        // 2.两种提交方式代码不一致
        // 可以使用通用的获取参数的方法

        // 根据指定参数名(表单中 name 属性值)获取参数值
        String username = request.getParameter("username");
        System.out.println(username);
        System.out.println("========================");

        // 获取所有参数名的集合
        Enumeration<String> parameterNames = request.getParameterNames();
        // 迭代获取所有指定参数名的参数值
        while (parameterNames.hasMoreElements()) {
            String parameter = request.getParameter(parameterNames.nextElement());
            System.out.println(parameter);
        }
        System.out.println("========================");

        // 获取参数名与参数值的 map 集合对象列表，键是参数名，值是参数值
        Map<String, String[]> parameterMap = request.getParameterMap();
        // map 集合的遍历方式
        // 1.entrySet 遍历键值对
        // 2.values 遍历值
        // 3.ketSet 遍历键
        // 4.Stream.forEach
        // 5.forEach
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            // 复选框可能会有多个参数值
            System.out.println(entry.getKey() + ":" + entry.getValue()[0]);
        }
        System.out.println("========================");
    }
}
