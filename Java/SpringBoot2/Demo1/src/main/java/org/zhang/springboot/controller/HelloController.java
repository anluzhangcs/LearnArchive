package org.zhang.springboot.controller;

/**
 * @author: zhanghao
 * @date: 2022/4/6-23:10
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 */

//@Controller
//@ResponseBody

@RestController //上述两个注解的组合注解
public class HelloController {

    @RequestMapping("/hello")
    public String hander1() {
        return "Hello SpringBoot";
    }
}
