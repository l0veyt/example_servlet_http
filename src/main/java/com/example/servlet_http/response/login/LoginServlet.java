package com.example.servlet_http.response.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/26.
 * 登录模拟
 */
public class LoginServlet extends HttpServlet {

    private static final String user = "admin";
    private static final String pwd = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(user.equals(username) && pwd.equals(password)) {
            // sendRedirect方法相当于把setStatus(302)和setHeader("location","xxx")封装了
            resp.sendRedirect("/login/success.html");
        }else {
            resp.sendRedirect("/login/fail.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
