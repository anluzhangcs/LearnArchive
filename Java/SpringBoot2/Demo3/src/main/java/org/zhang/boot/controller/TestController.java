package org.zhang.boot.controller;

/**
 * @author: zhanghao
 * @date: 2022/4/16-16:46
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 */

@RestController
public class TestController {

    @RequestMapping("/hello.png")
    public String hello() {
        return "haha";
    }
}
