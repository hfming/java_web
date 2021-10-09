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
import java.util.HashSet;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-17 19:23
 * @Description
 * @date 2020/8/17
 */
@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductServer productServer = new ProductServerImpl();
        // 获取所有商品
        List<Product> products = productServer.getProducts();

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>商品目录</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<table align=\"center\" border=\"1px\" cellspacing=\"0px\" width=\"600px\">\n" +
                "\t\t\t<thead>\n" +
                "\t\t\t\t<caption>商品目录</caption>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<th>商品编号</th>\n" +
                "\t\t\t\t\t<th>商品名称</th>\n" +
                "\t\t\t\t\t<th>商品型号</th>\n" +
                "\t\t\t\t\t<th>商品价格</th>\n" +
                "\t\t\t\t\t<th>查看详情</th>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</thead>\n" +
                "\t\t\t<tbody>\n";
        for (Product product : products) {
            html += "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<td>" + product.getId() + "</td>\n" +
                    "\t\t\t\t\t<td>" + product.getName() + "</td>\n" +
                    "\t\t\t\t\t<td>" + product.getType() + "</td>\n" +
                    "\t\t\t\t\t<td>" + product.getPrice() + "</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t<a href=\"/session/detileProduct?id=" + product.getId() + "\">配置详情</a>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr>\n";
        }
        // 去除重复
        HashSet<Product> visitedProduct = new HashSet<>();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Products".equalsIgnoreCase(cookie.getName())) {
                    String value = cookie.getValue();
                    String[] split = value.split("\\|");
                    for (String id : split) {
                        // 将查询到的结构添加到集合
                        visitedProduct.add(productServer.getProductById(id));
                    }
                }
            }
        }
        html += "\t\t\t</tbody>\n" +
                "\t\t\t<tfoot>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td colspan=\"5\">\n" +
                "\t\t\t\t\t\t最近浏览过的商品：<br />\n";
        if (visitedProduct != null) {
            for (Product product : visitedProduct) {
                html += product.getId() + "&nbsp&nbsp&nbsp&nbsp"
                        + product.getName() + "&nbsp&nbsp&nbsp&nbsp"
                        + product.getType() + "&nbsp&nbsp&nbsp&nbsp"
                        + product.getPrice() + "<br/>";
            }
        }
        html += "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</tfoot>\n" +
                "\t\t</table>\n" +
                "\t</body>\n" +
                "</html>\n";

        // 写出到浏览器
        response.getWriter().write(html);
    }
}
