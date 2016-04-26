package com.example.servlet_http.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/26.
 * 请求方法演示
 */
public class RequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String protocol = request.getProtocol();
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();
        String remoteUser = request.getRemoteUser();
        String remoteHost = request.getRemoteHost();
        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();

        // 虚拟路径需要在tomcat配置文件中配置的
        String info =
            "虚拟路径：" + contextPath + "<br/>" +
            "协议：" + protocol + "<br/>" +
            "请求方式：" + method + "<br/>" +
            "请求URI：" + requestURI + "<br/>" +
            "请求URL：" + requestURL + "<br/>" +
            "查询参数：" + queryString + "<br/>" +
            "远程地址：" + remoteAddr + "<br/>" +
            "远程用户：" + remoteUser + "<br/>" +
            "远程主机：" + remoteHost + "<br/>" +
            "本地服务器地址：" + localAddr + "<br/>" +
            "本地服务器名称：" + localName + "<br/>";
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(info);
    }
}
