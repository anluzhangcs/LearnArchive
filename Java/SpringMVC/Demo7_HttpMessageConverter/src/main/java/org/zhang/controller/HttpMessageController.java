package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2022/1/20-22:03
 */

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhang.bean.User;

/**
 * @Description
 */

@Controller
public class HttpMessageController {

    @RequestMapping("/testRequestBody")
    /*
     * 注:使用@RequestBody来获取请求体,前提是必须要有请求体,即要使用post方法.
     */
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getHeaders());
        System.out.println(requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "scuccess";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User("张三", "男", 22);
    }




    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }
}
