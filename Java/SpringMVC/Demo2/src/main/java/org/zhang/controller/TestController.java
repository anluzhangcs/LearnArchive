package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/5-15:46
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/param")
    public String toParam() {
        return "param";
    }

}
