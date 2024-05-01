package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/12/1-12:13
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zhang.service.BankService;

/**
 * @Description Spring整合Junit4框架
 */

@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架
@ContextConfiguration("classpath:spring.xml") //加载配置文件
public class Junit4Test {

    @Autowired //自动注入bankService
    private BankService bankService;

    @Test
    public void test1() {
        bankService.transferAccount(1, 2, 100);
    }
}
