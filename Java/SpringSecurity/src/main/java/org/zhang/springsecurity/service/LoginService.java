package org.zhang.springsecurity.service;

/**
 * @author: zhanghao
 * @date: 2022/7/23-21:44
 */

import org.zhang.springsecurity.bean.User;
import org.zhang.springsecurity.utils.ResponseResult;

/**
 * @Description
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
