package org.zhang.springsecurity.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Zhanghao
 * @date: 2022/7/26-16:03
 * @Description TODO
 */
@SpringBootTest
class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void test() {
        List<String> perms = menuMapper.selectPermsByUserId(1L);
        System.out.println(perms);
    }

}