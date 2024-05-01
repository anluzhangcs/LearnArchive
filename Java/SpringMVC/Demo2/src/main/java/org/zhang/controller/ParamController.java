package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/6-10:36
 */

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhang.bean.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 测试获取请求参数
 */

@Controller
public class ParamController {

    //使用Servlet原生API获取请求参数
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("username"));
        return "success";
    }

    //使用控制器方法形参获取请求参数
    @RequestMapping("/testFormalParam")
    public String testFormalParam(String username) {
        //要求请求参数名必须和形参名相同,否则不会自动注入
        System.out.println(username);
        return "success";
    }

    //使用控制器方法形参获取请求参数加强版,用于请求参数名和形参名不一致的情况
    @RequestMapping("/testFormalParamPlus")
    public String testFormalParamPlus(@RequestParam(value = "username") String user_name) {
        System.out.println(user_name);
        return "success";
    }

    //使用pojo,自动将匹配参数装入实体类bean中
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }


    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Host") String host){
        System.out.println(host);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testRequestCookie(@CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println(JSESSIONID);
        return "success";
    }



}
