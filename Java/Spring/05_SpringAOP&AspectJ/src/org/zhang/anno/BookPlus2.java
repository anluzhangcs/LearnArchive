package org.zhang.anno;

/**
 * @author: zhanghao
 * @date: 2021/11/25-16:42
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description 第二个增强类
 */


@Component
@Aspect
//Order注解,里面的值(0,1,...)值越小,优先级越高
@Order(1)
public class BookPlus2 {

    @Before("execution(* org.zhang.anno.Book.show(..))")
    public void before() {
        System.out.println("第二个增强类的before");
    }

}
