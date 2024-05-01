package org.zhang.dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/24-9:58
 */

import org.springframework.stereotype.Repository;
import org.zhang.dao.UserDao;

/**
 * @Description 使用注解来管理bean
 */


/*
 * -Repository注解一般用于Dao层
 * -value值和xml配置bean标签的id值含义相同,Spring IOC容器通过value值找到对应的bean对象.
 *  默认可以不写,不写为默认值,类名首字母小写
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void execute(){
        System.out.println("dao层被执行");
    }
}
