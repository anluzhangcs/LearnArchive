package org.zhang.service;

/**
 * @author: zhanghao
 * @date: 2021/11/30-12:38
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhang.bean.User;
import org.zhang.dao.UserDao;

import java.util.List;

/**
 * @Description 业务层
 */

@Service
public class UserService {

    @Autowired //按类型注入userDao的实现类
    private UserDao userDao;

    //增
    public void addUser(User user) {
        userDao.add(user);
    }

    //改
    public void updateUser(User user) {
        userDao.update(user);
    }

    //删
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }

    //查总数
    public Integer getCount() {
        return userDao.queryCount();
    }

    //查指定用户
    public User getUser(Integer id) {
        return userDao.queryUser(id);
    }

    //查集合
    public List<User> getAllUsers(){
        return userDao.queryAllUsers();
    }


    //批量操作
    public void addBatch(List<User> users) {
        userDao.addBatchUser(users);
    }

    public void updateBatch(List<User> users) {
        userDao.updateBatchUser(users);
    }


}
