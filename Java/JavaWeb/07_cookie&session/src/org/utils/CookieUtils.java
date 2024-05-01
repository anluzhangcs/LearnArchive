package org.utils;

/**
 * @author: zhanghao
 * @date: 2021/11/5-15:57
 */

import javax.servlet.http.Cookie;

/**
 * @Description cookie工具类
 */
public class CookieUtils {

    /*
     * @Description  查找指定Cookie
     * @param name 要查找的Cookie键名
     * @param cookies
     * @return  javax.servlet.http.Cookie
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {

        //首先进行基本判断
        if (name != null && cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }
}
