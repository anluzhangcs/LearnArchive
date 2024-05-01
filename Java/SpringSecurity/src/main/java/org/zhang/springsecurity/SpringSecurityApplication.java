package org.zhang.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("org.zhang.springsecurity.mapper")
public class SpringSecurityApplication {

    public static void main(String[] args) {
        //容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringSecurityApplication.class, args);
        //SpringSecurity本质上就是过滤器链
        System.out.println("springSecurityFilterChain");

    }


}
