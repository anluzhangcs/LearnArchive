package org.zhang.service;

/**
 * @author: zhanghao
 * @date: 2021/11/30-15:30
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhang.bean.Bank;
import org.zhang.dao.BankDao;

/**
 * @Description
 */

@Service
@Transactional //事务注解.声明在类上,类中所有方法都添加事务;声明在方法上,只有该方法添加事务

public class BankService {

    @Autowired
    private BankDao bankDao;

    //模拟转账
    public void transferAccount(int from,int des,double money) {

        bankDao.updateAccount(new Bank(from, -money));

        //模拟转账异常.导致数据前后不一致
        int i = 10/0;

        //转入,余额增加money.to为转入账户id
        bankDao.updateAccount(new Bank(des, money));

    }

}
