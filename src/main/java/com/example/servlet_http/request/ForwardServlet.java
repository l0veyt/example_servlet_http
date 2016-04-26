package com.example.servlet_http.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/27.
 * 转发
 */
public class ForwardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 重定向和转发的区别
         * 重定向：
         *  2次请求 Client -> Server -> Client -> Server -> Client
         *  地址发生变化
         *  可以定位到任何资源（例如：www.google.com）
         *
         * 转发：
         *  1次请求 Client -> Server -> Server -> Client
         *  地址不变
         *  只能定位到本项目中的资源（example_servlet_http）
         *
         * request域有效范围只有1次请求，能在转发中使用，不能在重定向中使用
         */
        request.setAttribute("forwardValue", "yoo");
        request.getRequestDispatcher("/refererServlet").forward(request, response);
    }
}
