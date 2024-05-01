package org.zhang.springboot.controller;

/**
 * @author: zhanghao
 * @date: 2022/7/11-17:16
 */

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.PojoHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description 测试文件上传
 */
@Controller
@Slf4j //Lombok提供日志打印
public class FormController {

    @GetMapping("/form_layout")
    public String formLayout() {

        return "form/form_layouts";
    }

    /*
     * @Description  上传文件并存到服务器
     * @param
     * @return  java.lang.String
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email, @RequestParam("password") String password
    , @RequestPart("logo") MultipartFile logo,@RequestPart("pothos") MultipartFile[] pothos) throws IOException {

        System.out.println(email);
        System.out.println(password);
        System.out.println(logo.getSize());
        System.out.println(pothos.length);

        if (logo != null) { //首先判断文件是否为空
            String originalFilename = logo.getOriginalFilename();
            System.out.println(originalFilename);
            logo.transferTo(new File("D:\\" + originalFilename));
        }

        //判断文件保存路径是否存在
        File destFile = new File("D:\\pothos");
        if (!destFile.exists()) {
            destFile.mkdir(); //没有则创建该目录
        }

        if (pothos.length > 0) {
            for (MultipartFile potho : pothos) {
                if (potho != null) {
                    String originalFilename = potho.getOriginalFilename();
                    potho.transferTo(new File(destFile + "\\" + originalFilename));
                }
            }
        }

        return "main";
    }
}
