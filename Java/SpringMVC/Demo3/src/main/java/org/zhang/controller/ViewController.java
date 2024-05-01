package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/8-12:36
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 */


@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}
