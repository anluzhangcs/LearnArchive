package org.zhang.service.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/24-10:11
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zhang.dao.UserDao;
import org.zhang.service.UserService;

import javax.annotation.Resource;

/**
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {

    /*
     * ①@Autowired:根据类型自动注入,类似于xml配置中bean标签autowire属性为byType
     *  此例中类型为UserDao,找到它的实现类创建对象并注入.如果有多个实现类则找不到
     * ②@Qualifier(要和@Autowired配合使用):根据名称注入,类似于xml配置中bean标签autowire属性值为byName.
     *  注:byName要求该类要注入的属性名要和属性类bean标签的id值相同,而@Qulifier可以根据value属性
     *      值设置要寻找的bean,不一定非要属性名和寻找的bean相同
     * ③@Resource:由javax(java扩展包)提供.既可以根据类型注入,单独的一个注解;
     *              又可以根据名称注入,注解加上name属性
     *  注:Spring官方一般推荐使用Spring提供的Autowired和Qualifier,Value
     * ④@Value:注入基本数据类型和String
     */

    @Autowired
    private UserDao userDao;

//    @Autowired
//    @Qualifier(value = "userDaoImpl")
//    private UserDao userDao;

//    @Resource
//    private UserDao userDao;

//    @Resource(name = "userDaoImpl")
//    private UserDao userDao;

    @Value("zahngsan")
    private String name;
    @Value("2")
    private Integer age;

    @Override
    public void login() {
        System.out.println("Service层执行"+name+age);
        userDao.execute();
    }
}
