package org.zhang.boot.controller;

/**
 * @author: zhanghao
 * @date: 2022/4/18-14:21
 */

import org.springframework.web.bind.annotation.*;

/**
 * @Description
 */

@RestController
public class UserController {


    @GetMapping("/user")
    public String getUser() {
        return "REST-GET";
    }

    @PostMapping("/user")
    public String postUser() {
        return "REST-POST";
    }

    @PutMapping("/user")
    public String putUser() {
        return "REST-PUT";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "REST-DELETE";
    }

}
