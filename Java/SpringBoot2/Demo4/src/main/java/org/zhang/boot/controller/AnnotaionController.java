package org.zhang.boot.controller;

/**
 * @author: zhanghao
 * @date: 2022/4/23-11:14
 */

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 */

@RestController
public class AnnotaionController {

    @RequestMapping("/book/{id}/{username}")
    public Map testPathVariable(@PathVariable("id") int id, @PathVariable("username") String username, @PathVariable Map<String, String> pv) {
        //使用@PathVariable注解声明的Map<String,String>默认会保存所有路径变量
        Map map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);

        return map;
    }

    @RequestMapping("/book")
    public Map testRequestParam(int id, @RequestParam("username") String username,@RequestParam Map<String,String> rp) {
        //同@PathVariable,使用Map<String,String>保存所有参数

        Map map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("username", username);
        map.put("rp", rp);

        return map;
    }

    @RequestMapping("/book/1")
    public Map test3(@RequestHeader Map<String, String> header,@CookieValue(required = false) Cookie cookie, @RequestBody String body) {
        Map map = new HashMap<String, Object>();
        map.put("header", header);
        map.put("body", body);
        map.put("cookie", cookie);

        return map;
    }

//    @ModelAttribute




}
