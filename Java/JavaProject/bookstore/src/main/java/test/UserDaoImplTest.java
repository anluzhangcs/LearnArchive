package test;

import bean.User;
import dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2021/10/30-22:52
 */
public class UserDaoImplTest {

    @Test
    public void queryByName() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryByName("admin");
        System.out.println(user);
    }

    @Test
    public void queryByEmail() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryByEmail("123@qq.com");
        System.out.println(user);
    }

    @Test
    public void addUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.addUser(new User(null, "zhangsan", "123456", "anluzhang@qq.com"));
    }

    @Test
    public void queryForLogin() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryForLogin("admin", "admin");
        System.out.println(user);
    }
}