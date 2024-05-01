package org.zhang.servlet;

/**
 * @author: zhanghao
 * @date: 2021/11/7-10:12
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断登录信息是否正确
        if ("zhangsan".equals(username) && "123456".equals(password)) {
            //将登录信息保存到Session域中
            req.getSession().setAttribute("user",username);
            req.getRequestDispatcher("/admin/login_success.jsp").forward(req, resp);
        } else{ //登陆失败
            req.getRequestDispatcher("/admin/a.jsp").forward(req, resp);
        }
    }
}
