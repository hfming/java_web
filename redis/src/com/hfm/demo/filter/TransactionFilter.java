package com.hfm.demo.filter;


import com.hfm.demo.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-07 0:20
 * @Description
 * @date 2020/9/7
 */
@WebFilter(filterName = "TransactionFilter", urlPatterns = "/*")
public class TransactionFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("Filter 过滤器 - 销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 转换成 HttpServletRequest
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try {
            chain.doFilter(req, resp);
            // 提交事务
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            // 回滚事务
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter 过滤器 - 启动");
    }
}
