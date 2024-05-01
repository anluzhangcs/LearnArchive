package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2022/1/21-16:58
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description 实现上传和下载
 */

@Controller
public class FileController {

    @RequestMapping("/testDownload")
    public ResponseEntity<byte[]> testDownload(HttpSession session) throws IOException {
        //1.获取上下文对象
        ServletContext servletContext = session.getServletContext();

        //2.获取资源在服务器中的真实路径
        String realPath = servletContext.getRealPath("/static/sounds/bensound-wildblood.mp3");

        //3.创建文件读取流
        FileInputStream is = new FileInputStream(realPath);

        //4.创建存放数据的字节数组并读入到数组中
        byte[] bytes = new byte[is.available()];
        is.read(bytes);

        //5.设置响应头
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition","attachment;filename=abc.mp3");

        //6.设置响应状态码
        HttpStatus status = HttpStatus.OK;

        //7.关闭输入流
        is.close();

        //8.创建自定义响应报文并返回
        return new ResponseEntity<byte[]>(bytes,headers, status);
    }

    @RequestMapping("/testUpload")
    public String testUpload(MultipartFile upload,HttpSession session) throws IOException { //获取到上传文件并将其转换为MultipartFile类型

        //1.获取文件名和该文件表单的name
//        System.out.println(upload.getName());
        String filename = upload.getOriginalFilename(); //真正的文件名

        //可选:确保同名文件下载时不会覆盖,即使用UUID尽量使得不会出现同名文件
        String[] split = filename.split("\\.");
        //获取文件后缀
        String suffix = split[split.length - 1];
        String prefix = UUID.randomUUID().toString();
        filename = prefix + "." + suffix;


        //2.选择上传到服务器哪个位置存放
        ServletContext servletContext = session.getServletContext();
        String destPath = servletContext.getRealPath("music");

        //3.判断该目录是否存在,若不存在则创建该目录
        File music = new File(destPath);
        if (!music.exists()) {
            music.mkdir();
        }

        //4.创建该文件对象
        File finalFile = new File(destPath + "\\" +filename);

        //5.将该文件复制到此位置
        upload.transferTo(finalFile);

        return "success";
    }

}
