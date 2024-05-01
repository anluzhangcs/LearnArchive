package org.controller;

/**
 * @author: zhanghao
 * @date: 2021/11/5-16:43
 */

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 免用户名登录
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断用户名和密码是否正确
        if ("zhang".equals(username) && "123456".equals(password)) {
            //如果正确,则创建用户名的cookie,下次就不用输入用户名了
            Cookie cookie = new Cookie("username", "zhang");
            cookie.setMaxAge(60 * 60); //给它1小时的生命期
            resp.addCookie(cookie); //回传给浏览器保存
        }
    }
}
