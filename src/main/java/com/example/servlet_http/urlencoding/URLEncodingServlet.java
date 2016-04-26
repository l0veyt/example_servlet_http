package com.example.servlet_http.urlencoding;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/26.
 * URL编码测试
 */
public class URLEncodingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 网页开始提交参数时，都会对中文进行URL编码
         */

        // TODO GET方式直接获取中文参数并没有乱码？？？
        String wd = request.getParameter("wd");
        System.out.println(wd);
    }
}
