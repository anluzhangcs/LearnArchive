package org.zhang.anno;

/**
 * @author: zhanghao
 * @date: 2021/11/25-16:07
 */

import org.springframework.stereotype.Component;

/**
 * @Description 要被增强方法的类
 */

@Component
public class Book {


    public void show() {
//        int i= 10/0;
        System.out.println("基本的方法,还没有被增强");
    }
}
