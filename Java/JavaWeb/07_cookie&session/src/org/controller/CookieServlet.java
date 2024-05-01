package org.controller;

/**
 * @author: zhanghao
 * @date: 2021/11/5-15:44
 */


import org.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 用于测试cookie的servlet
 */
public class CookieServlet extends BaseServlet {


    /*
     * @Description  测试cookie路径
     * @param req
     * @param resp
     * @return  void
     */
    protected void cookiePath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认情况下cookie路径为当前工程路径,工程下每个页面都会有为工程路径的cookie
        Cookie cookie1 = new Cookie("key1", "value1");
        resp.addCookie(cookie1);

        //只有/07_cookie&session/cookie.html及以下页面才会有该cookie
        Cookie cookie2 = new Cookie("key2", "value2");
        cookie2.setPath("/07_cookie&session/cookie.html");
        resp.addCookie(cookie2);

        Cookie cookie3 = new Cookie("key3", "value3");
        cookie3.setPath("/07_cookie&session/session.html");
        resp.addCookie(cookie3);
    }


    /*
     * @Description  cookie生命周期
     * @param req
     * @param resp
     * @return  void
     */
    protected void cookieLifeTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认生命周期为session,即一次会话
        Cookie cookie1 = new Cookie("key1", "value1");
        resp.addCookie(cookie1);

        /*
         * 通过setMaxAge(int expiry)设置cookie的生命期为多少秒
         *  -正数代表生命期为多少秒
         *  -0代表即刻销毁
         *  -负数代表也是生命期也是session,默认-1
         */

        Cookie cookie2 = new Cookie("key2", "value2");
        cookie2.setMaxAge(6);
        resp.addCookie(cookie2);

        Cookie cookie3 = new Cookie("key3", "value3");
        cookie3.setMaxAge(0);
        resp.addCookie(cookie3);

        Cookie cookie4 = new Cookie("key4", "value4");
        cookie4.setMaxAge(-6);
        resp.addCookie(cookie4);
    }



    /*
     * @Description  修改cookie
     * @param req
     * @param resp
     * @return  void
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建键名相同的cookie
        Cookie cookie = new Cookie("key1", "newValue");

        //2.通过响应传递给浏览器
        resp.addCookie(cookie);
    }

    /*
     * @Description  获取cookie
     * @param req
     * @param resp
     * @return  void
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取浏览器发送的所有cookie
        Cookie[] cookies = req.getCookies(); //返回Cookies数组

        //2.对Cookies[]遍历
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()); //getName()获取键名
            System.out.println(cookie.getValue()); //getValue()获取值
        }

        //常见操作:如何找到指定的cookie
        Cookie cookie = CookieUtils.findCookie("key1", cookies);
        if (cookie != null) { //判断是否为空,避免NullPointerException
            System.out.println(cookie.getValue());
        }
    }
    /*
     * @Description  创建cookie
     * @param req
     * @param resp
     * @return  void
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象,必须给一个key和一个value,保存键值对
        Cookie cookie = new Cookie("key1","value1");

        //2.通过响应发送给客户端,即设置响应头的Cookie.然后客户端看到响应头有cookie信息,就保存
        resp.addCookie(cookie); //必须操作

    }


}
