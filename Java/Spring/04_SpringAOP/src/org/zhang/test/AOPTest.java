package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/25-11:52
 */

import org.junit.Test;
import org.zhang.dao.UserDao;
import org.zhang.dao.impl.UserDaoImpl;
import org.zhang.proxy.ProxyFactory;

/**
 * @Description
 */
public class AOPTest {

    @Test
    public void test1() {
        UserDao proxyInstance = (UserDao) ProxyFactory.getProxyInstance(new UserDaoImpl());
        System.out.println(proxyInstance.getClass());
        proxyInstance.login();
    }
}
