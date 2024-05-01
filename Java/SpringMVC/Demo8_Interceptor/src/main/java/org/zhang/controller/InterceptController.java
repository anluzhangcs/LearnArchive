package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2022/1/21-21:50
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 */

@Controller
public class InterceptController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {

        return "success";
    }

    @RequestMapping("/testException")
    public String testException() {
        String s = null;
        System.out.println(s.length());
        return "success";
    }

}
