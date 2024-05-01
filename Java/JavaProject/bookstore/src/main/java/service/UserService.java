package service;

/**
 * @author: zhanghao
 * @date: 2021/10/30-22:58
 */

import bean.User;

/**
 * @Description UserService业务层(Service层),完成User所需的业务
 */
public interface UserService {


    boolean regist(User user);

    int login(User user);

}
