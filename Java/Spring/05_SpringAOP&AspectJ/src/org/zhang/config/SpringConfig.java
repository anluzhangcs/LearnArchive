package org.zhang.config;

/**
 * @author: zhanghao
 * @date: 2021/11/25-17:10
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description 全注解开发
 */

@Configuration
//替代配置component-scan
@ComponentScan(basePackages = {"org.zhang.anno"})
//替代配置component-scan
@EnableAspectJAutoProxy
public class SpringConfig {

}