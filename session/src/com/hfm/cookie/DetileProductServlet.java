package com.hfm.cookie;

import com.hfm.pojo.Product;
import com.hfm.contact.server.ProductServer;
import com.hfm.contact.server.impl.ProductServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 21:21
 * @Description
 * @date 2020/8/17
 */
@WebServlet(name = "DetileProductServlet", urlPatterns = "/detileProduct")
public class DetileProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ProductServer productServer = new ProductServerImpl();
        String id = request.getParameter("id");

        Product product = productServer.getProductById(id);

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>商品详情</title>\n" +
                "\t</head>\n" +
                "\n" +
                "\t<body>\n" +
                "\t\t<form action=\"/session/changeProduct\" method=\"post\">\n" +
                "\t\t\t<table align=\"center\" border=\"1px\" cellspacing=\"0px\" width=\"400px\">\n" +
                "\t\t\t\t<thead>\n" +
                "\t\t\t\t\t<caption>商品详情</caption>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<th>项目名称</th>\n" +
                "\t\t\t\t\t\t<th>查询结果</th>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</thead>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td>商品名称</td>\n" +
                "\t\t\t\t\t\t<td><input type=\"text\" value=\"" + product.getName() + "\" name=\"name\" /> </td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td>商品型号</td>\n" +
                "\t\t\t\t\t\t<td><input type=\"text\" value=\"" + product.getType() + "\" name=\"type\" /> </td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td>商品价格</td>\n" +
                "\t\t\t\t\t\t<td><input type=\"number\" value=\"" + product.getPrice() + "\" name=\"price\" /> </td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td>商品详情</td>\n" +
                "\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t<textarea>\n" +
                "\t\t\t\t\t\t\t联想笔记本时是联想旗下的主要产品之一\n" +
                "\t\t\t\t\t\t\t</textarea>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t\t<tfoot>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\n" +
                "\t\t\t\t\t\t\t<input type=\"submit\" value=\"确认修改\" />\n" +
                "\t\t\t\t\t\t\t<a href=\"/session/products\">\n" +
                "\t\t\t\t\t\t\t\t<input type=\"button\" value=\"返回首页\" id=\"but\" />\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tfoot>\n" +
                "\t\t\t</table>\n" +
                "\t\t</form>\n" +
                "\t</body>\n" +
                "\n" +
                "</html>";

        getProductCookie(request, response, id);

        response.getWriter().write(html);
    }

    private void getProductCookie(HttpServletRequest request, HttpServletResponse response, String id) {
        Cookie[] cookies = request.getCookies();

        String value = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Products".equalsIgnoreCase(cookie.getName())) {
                    value = cookie.getValue();
                    break;
                }
            }
        }
        // 如果没有 cookie 则添加
        if (cookies == null || value == null) {
            Cookie cookie = new Cookie("Products", id);
            response.addCookie(cookie);
        } else {
            String[] split = value.split("\\|");
            List<String> strings = Arrays.asList(split);
            LinkedList<String> list = new LinkedList<>(strings);
            if (list.size() < 3) {
                if (list.contains(id)) {
                    list.remove(id);
                    list.addFirst(id);
                }else{
                    list.addFirst(id);
                }
            }else{
                if (list.contains(id)) {
                    list.remove(id);
                    list.addFirst(id);
                }else{
                    list.removeLast();
                    list.addFirst(id);
                }
            }
            String result = "";
            for (String s : list) {
                result += s + "|";
            }
            result.substring(0, result.length() - 1);

            Cookie products = new Cookie("Products", result);
            response.addCookie(products);
        }
    }
}
