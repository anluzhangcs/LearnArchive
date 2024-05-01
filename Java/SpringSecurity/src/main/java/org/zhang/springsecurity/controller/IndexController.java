package org.zhang.springsecurity.controller;

/**
 * @author: zhanghao
 * @date: 2022/7/22-23:00
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 */
@Controller
@RestController
public class IndexController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('system:dept:list111')") //判断有此权限handler才会执行
    public String index() {
        return "hello SpringSecurity";
    }
}
