package org.zhang.springboot.config;

/**
 * @author: zhanghao
 * @date: 2022/7/11-11:54
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zhang.springboot.intercepter.LoginIntercepter;

/**
 * @Description 通过配置类配置拦截器
 */

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    /*
     * @Description  注册拦截器
     * @param null
     * @return
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行
    }
}
