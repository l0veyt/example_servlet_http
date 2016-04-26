package com.example.servlet_http.response.referer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/25.
 * 链接来源（可用作简单的防盗链）
 */
public class RefererServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forwardValue = (String)req.getAttribute("forwardValue");
        // 获取链接来源（直接浏览器访问则为null）
        String referer = req.getHeader("referer");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("此链接来自：" + referer);
        if(forwardValue != null) {
            resp.getWriter().write("<br/>request域：" + forwardValue);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
