package org.zhang.controller.exception;

/**
 * @author: zhanghao
 * @date: 2022/1/22-20:51
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 异常处理类
 */

/*
    @ControllerAdvice注解标识这是一个异常处理器,本质上就是一个Controller
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    //当出现上述异常时就会执行该方法,返回的视图名称即为出现异常后跳转的视图.
    public String testNullPointerException(Exception ex, Model model) {
    //形参中Exception对象获取异常信息,Model对象将其添加到request域中
        model.addAttribute("ex", ex);
        return "error";
    }

}
