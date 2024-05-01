package org.zhang.springsecurity.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zhang.springsecurity.bean.User;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author: zhanghao
 * @date: 2022/7/22-22:15
 */

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {
        userMapper.selectList(null);

    }

}