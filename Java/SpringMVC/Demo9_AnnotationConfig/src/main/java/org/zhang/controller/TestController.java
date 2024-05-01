package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2022/1/23-15:07
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 */

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String toHello() {

        return "hello";
    }

    @RequestMapping("/testException")
    public String testException() {
        System.out.println(1/0);
        return "hello";
    }

}
