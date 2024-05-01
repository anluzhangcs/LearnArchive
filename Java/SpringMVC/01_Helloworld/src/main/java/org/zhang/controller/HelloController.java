package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/5-11:50
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Description 请求控制器
 *
 * 一开始每个请求都对应一个实现了Servlet的控制器,每个控制器(Servlet)都需要在web.xml文件中配置
 * 现在只需要配置前端控制器DispatcherServlet接收所有请求,然后创建请求控制器并交给SpringIOC容器
 * 管理.根据请求地址映射到相应的请求控制器的方法
 */

@Controller
public class HelloController{

    //@RequsetMapping注解处理请求地址和请求控制器方法间的映射.value属性值即为请求地址
    @RequestMapping("/")
    public String index() {
        //返回视图名称,并交给视图解析器解析,从而找到对应的页面
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

}
