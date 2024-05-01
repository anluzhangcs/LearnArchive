package org.zhang.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Zhanghao
 * @date: 2022/7/26-20:09
 * @Description 自定义WebMvc配置类
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //允许跨域 ---SpringBoot配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //允许跨域的请求路径
                .addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}
