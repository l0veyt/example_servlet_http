package com.example.servlet_http.response.encoding;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/26.
 * 字节字符流编码
 */
public class EncodingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 同一个页面只能使用一种流，不能同时向页面响应，字节流和字符流是互斥的，不能同时使用
        String userEncoding = request.getParameter("userEncoding");
        if("doByte".equals(userEncoding)) {
            doByte(response);
        }
        if("doChar".equals(userEncoding)) {
            doChar(response);
        }
    }

    /**
     * 获取字节流输出中文
     */
    private void doByte(HttpServletResponse response) throws IOException {
        // 设置浏览器解析页面时所使用的编码为UTF-8
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        // 设置输出到页面中的文字的编码为UTF-8
        response.getOutputStream().write("中文".getBytes("UTF-8"));
    }

    /**
     * 获取字符流输出中文
     */
    private void doChar(HttpServletResponse response) throws IOException {
        // 设置浏览器解析页面时所使用的编码为UTF-8
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        // 设置response对象缓冲区的编码
        response.setCharacterEncoding("UTF-8");

        /**
         * response提供了setContentType方法，执行该方法就相当于上两行代码
         * response.setContentType("text/html;charset=UTF-8");
         */
        response.getWriter().write("中文");
    }

}
