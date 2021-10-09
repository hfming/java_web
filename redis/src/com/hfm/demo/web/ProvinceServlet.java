package com.hfm.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfm.demo.pojo.Province;
import com.hfm.demo.server.ProvinceServer;
import com.hfm.demo.server.impl.ProvinceServerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-08 11:04
 * @Description
 * @date 2020/9/8
 */
@WebServlet(name = "ProvinceServlet", urlPatterns = "/province")
public class ProvinceServlet extends BaseServlet {
    private ProvinceServer provinceServer = new ProvinceServerImpl();

    /**
     * 查询所有省份
     *
     * @param request
     * @param response
     */
    private void provinces(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Province> provinces = provinceServer.provinces();

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(provinces);

            // 设置响应格式
            response.setContentType("application/json,charset=utf-8");

            response.getWriter().write(s);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询所有省份
     *
     * @param request
     * @param response
     */
    private void provincesJson(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 直接获取json 数据
            String s = provinceServer.provincesJsonFormRedis();

            // 设置响应格式
            response.setContentType("application/json,charset=utf-8");

            response.getWriter().print(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
