package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/6-15:22
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 用于跳转不同页面
 */

@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView() {
        return "test_view";
    }
}
