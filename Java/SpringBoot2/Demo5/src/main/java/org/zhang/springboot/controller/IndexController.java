package org.zhang.springboot.controller;

/**
 * @author: zhanghao
 * @date: 2022/7/10-16:36
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zhang.springboot.bean.User;

import javax.servlet.http.HttpSession;

/**
 * @Description 登录
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(User user, HttpSession session, Model model) {
        //判断用户名和密码是否正确
        if (StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())) {
            session.setAttribute("user", user); //放到Session域中
            return "redirect:/main.html"; //重定向解决表单重复提交
        } else {
            //向请求域request 中共享数据
            model.addAttribute("msg", "用户名或密码错误");
            return "login"; //返回到登陆页面
        }

    }

    @GetMapping("main.html")
    public String login(HttpSession session, Model model) {
//        //判断是否登录
//        if (session.getAttribute("user") == null) {
//            model.addAttribute("msg", "请输入用户名和密码");
//            return "login";
//        }

        return "main";
    }
}
