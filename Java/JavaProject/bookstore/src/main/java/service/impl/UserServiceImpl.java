package service.impl;

/**
 * @author: zhanghao
 * @date: 2021/10/30-23:03
 */

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @Description
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        //1.判断用户名是否存在,邮箱是否已绑定
        User queryByName = userDao.queryByName(user.getUsername());
        User queryByEmail = userDao.queryByEmail(user.getEmail());
        if (queryByName == null) {
            //用户名不存在
            if (queryByEmail == null) {
                //邮箱没有被绑定
                userDao.addUser(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public int login(User user) {

        User queryByName = userDao.queryByName(user.getUsername());
        User queryForLogin = userDao.queryForLogin(user.getUsername(), user.getPassword());
        if (queryByName == null) {
            return -1;
        } else {
            if (queryForLogin == null) {
                return 0;
            }
        }
        return 1;

    }
}
