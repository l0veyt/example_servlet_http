package com.example.servlet_http.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by Xin.Lee on 2016/4/26.
 * 获取参数
 */
public class ParameterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 解决请求参数乱码
         * POST提交：设置request缓冲区的编码
         *  request.setCharacterEncoding("UTF-8");
         *
         * GET提交：
         *  方法一：修改tomcat的conf目录下的server.xml（不推荐使用）
         *  <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
         *  追加URIEncoding="UTF-8"即可     必须要有修改tomcat服务器配置文件的权限
         *
         *  方法二：逆向编解码（不推荐使用）
         *  因为GET方式提交，请求的参数都是直接拼接且是在地址栏中的，会经过URL编码
         *  所以我们可以借助第三方类编解码
         *  username = URLEncoder.encode(username, "ISO8859-1");
         *  username = URLDecoder.decode(username, "UTF-8");
         *
         *  方法三：
         *  username = new String(username.getBytes("ISO8859-1"),"UTF-8");
         */
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        System.out.println("username:" + username);

        String[] parameterValues = request.getParameterValues("hobby");
        for (String value : parameterValues) {
            System.out.println("hobby:" + value);
        }
        Map parameterMap = request.getParameterMap();
        for (Object s : parameterMap.keySet()) {
            System.out.println("parameterMap:" + parameterMap.get(s));
        }
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println("parameterNames:" + parameterNames.nextElement());
        }
    }
}
