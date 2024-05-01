package org.zhang.dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/25-11:29
 */

import org.zhang.dao.UserDao;

/**
 * @Description
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void login() {
        System.out.println("普通的登陆业务逻辑");
    }


}
