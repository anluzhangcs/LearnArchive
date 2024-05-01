package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/8-14:55
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 */

@Controller
public class TestController {


    @RequestMapping("/success")
    public String success() {
        return "success";
    }

}
