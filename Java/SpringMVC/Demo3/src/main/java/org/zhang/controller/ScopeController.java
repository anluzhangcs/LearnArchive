package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2021/12/7-12:17
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description 域对象共享数据
 */

@Controller
public class ScopeController {


    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("requestScope","hello servletAPI");
        return "success";
    }

    //使用ModelAndView向请求域中共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {  //返回值必须为ModelAnaView,被前端控制器解析
        //创建ModelAndView
        // Model表示模型,在这里主要用于向域中共享数据
        // View表示视图,用于返回视图
        ModelAndView mv = new ModelAndView();
        mv.addObject("requestScope", "hello ModelAndView");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        System.out.println(model.getClass());
        model.addAttribute("requestScope", "hello Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass());
        map.put("requestScope", "hello Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        System.out.println(modelMap.getClass());
        modelMap.addAttribute("requestScope", "hello ModelMap");
        return "success";
    }


    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("sessionScope", "hello session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("applicationScope", "hello Application");
        return "success";
    }

}
