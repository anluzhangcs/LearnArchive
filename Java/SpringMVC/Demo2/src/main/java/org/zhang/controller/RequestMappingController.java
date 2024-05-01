package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/5-16:07
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description 测试RequestMapping注解
 */

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    //匹配多个请求地址
    @RequestMapping(value = {"test2", "test3"})
    public String success() {
        return "success";
    }

    //method属性匹配请求方法.不设置则不匹配,任何请求方法都行;设置了则需进行匹配
    @RequestMapping(value = {"test4", "test5"}, method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public String methodTest() {
        return "success";
    }

    /*
     * params匹配参数,也是String[],每一个字符串都是一个键值对.注意是全匹配
     *  "params"表示必须有这个参数
     *  "!params"表示必须没有此参数
     *  "params=xxx"表示必须有此参数,且值也要匹配
     *  "params!=xxx"表示①没有此参数②有此参数,且值不等于xxx
     *
     */
    @RequestMapping(value = "testParams", params = {"username", "password!=123"})
    public String testParams() {
        return "success";
    }

    @RequestMapping(value = {"/testHeaders"}, headers = {"Host=localhost:8080"})
    public String testHeaders() {
        return "success";
    }

//    @RequestMapping("/test?ant")
//    @RequestMapping("/test*ant")
    @RequestMapping("/**/testant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testRest/{username}/{password}")
    public String testRest(@PathVariable(name="username") String username,@PathVariable(name="password") String password) {
        System.out.println("用户名:" + username + ",密码:" + password);
        return "success";
    }

}
