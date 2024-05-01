package org.zhang.anno;

/**
 * @author: zhanghao
 * @date: 2021/11/25-16:08
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description 增强的逻辑的代理类
 */
@Component
@Aspect //Aspect注解表示要创建该增强的代理类
@Order(2)
public class BookPlus {

    //对相同的切入点表达式进行抽取,其它通知只需执行这个切入点函数即可
    @Pointcut(value = "execution(* org.zhang.anno.Book.show(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("在切入点方法之前执行...");
    }

    @Around("execution(* org.zhang.anno.Book.show(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕在切入点方法执行前执行");

        //被增强的方法执行
        joinPoint.proceed();

        System.out.println("环绕在切入点方法执行后执行");
    }

    @AfterReturning("execution(* org.zhang.anno.Book.show(..))")
    public void afterReturn() {
        System.out.println("在切入点方法返回之后执行");
    }

    @AfterThrowing("execution(* org.zhang.anno.Book.show())")
    public void afterThrowing() {
        System.out.println("在切入点方法出现异常后执行");
    }

    @After("execution(* org.zhang.anno.Book.show())")
    public void after() {
        System.out.println("最终执行,在切入点方法返回之前");
    }

}
