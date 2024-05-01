package org.zhang.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.zhang.springsecurity.bean.User;
import org.zhang.springsecurity.mapper.UserMapper;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Test
    void contextLoads() {
        System.out.println(authenticationEntryPoint);
    }

    @Test
    void mybatisplus() {

        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    void testBCrept() {
        //加密明文 $2a$10$EWtl1BTIomPmsbwjm8aMau2uaUdQe7wyu4laH1hNgrkTEw4IDoL16
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

        //1个明文可有多个密文,每次根据新的加密盐生成
        //一个密文只对应一个明文

        //将明文和加密之后的进行匹配
        boolean match = passwordEncoder.matches("12345", "$2a$10$4by86HwyWA5uLjGZ9BgouuB2Xu28g233BewBPnOSSphFr6OP0gHq6");
        System.out.println(match);
    }

}
