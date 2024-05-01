package org.zhang.springsecurity.controller;

/**
 * @author: zhanghao
 * @date: 2022/7/23-21:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhang.springsecurity.bean.User;
import org.zhang.springsecurity.service.LoginService;
import org.zhang.springsecurity.utils.ResponseResult;

/**
 * @Description
 */

@RestController()
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    //@ResponseBody注解将json格式请求参数封装为形参实体类对象
    public ResponseResult login(@RequestBody User user) {
        //返回响应结果
        return loginService.login(user);
    }

    @GetMapping("/logout")
    public ResponseResult logout() {

        return loginService.logout();
    }
}
