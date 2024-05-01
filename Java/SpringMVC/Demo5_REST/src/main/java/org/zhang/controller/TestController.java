package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/18-20:05
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhang.bean.User;

/**
 * @Description REST风格的测试
 */

@Controller
public class TestController {


    //查询操作
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUsers() {
        System.out.println("查询所有用户");
        return "success";
    }

    //根据id查询用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询用户"+id);
        return "success";
    }

    //保存用户
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(User user) {
        System.out.println("保存用户"+user);
        return "success";
    }

    //更新用户
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        System.out.println("更新用户"+user);
        return "success";
    }

    //删除用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(Integer id) {
        System.out.println("删除用户"+id);
        return "success";
    }

}
