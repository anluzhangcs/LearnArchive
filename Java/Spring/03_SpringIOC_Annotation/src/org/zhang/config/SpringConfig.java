package org.zhang.config;

/**
 * @author: zhanghao
 * @date: 2021/11/24-18:14
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 注解类,用于纯注解开发
 */

@Configuration //表明这是一个注解类
@ComponentScan(basePackages = "org.zhang") //声明注解扫描,和xml配置component-scan类似
public class SpringConfig {

}
