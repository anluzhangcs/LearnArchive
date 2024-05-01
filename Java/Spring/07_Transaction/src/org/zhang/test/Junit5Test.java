package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/12/1-12:13
 */




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.zhang.service.BankService;

/**
 * @Description Spring整合Junit5框架
 */
//第一种方式
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:spring.xml")

//此注解是对第一种两个注解的整合
@SpringJUnitConfig(locations = "classpath:spring.xml")
public class Junit5Test {

    @Autowired //自动注入bankService
    private BankService bankService;

    @Test
    public void test1() {
        bankService.transferAccount(1, 2, 100);
    }
}
