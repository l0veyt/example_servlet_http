package com.example.servlet_http.response.location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/25.
 * 重定向302
 */
public class LocationServlet extends HttpServlet {

    /**
     * 转发和重定向的区别：
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置重定向状态码302
        resp.setStatus(302);
        // 设置location响应头
        resp.setHeader("location", "/refererServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
