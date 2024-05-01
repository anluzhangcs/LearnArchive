package org.zhang.boot.controller;

/**
 * @author: zhanghao
 * @date: 2022/4/15-17:03
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhang.boot.bean.Student;

/**
 * @Description
 */

@RestController
public class HelloController {

    @Autowired
    private Student student;

    @RequestMapping("/hello")
    public Student hello() {
        System.out.println(student.getName());
        return student;
    }

}
