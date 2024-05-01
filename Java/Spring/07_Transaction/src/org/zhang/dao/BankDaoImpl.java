package org.zhang.dao;

/**
 * @author: zhanghao
 * @date: 2021/11/30-15:29
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.zhang.bean.Bank;

/**
 * @Description
 */

@Repository
public class BankDaoImpl implements BankDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //更新账户
    @Override
    public void updateAccount(Bank bank) {
        String sql = "update bank set balance = balance+? where id = ?";
        jdbcTemplate.update(sql, bank.getBalance(), bank.getId());
    }
}
