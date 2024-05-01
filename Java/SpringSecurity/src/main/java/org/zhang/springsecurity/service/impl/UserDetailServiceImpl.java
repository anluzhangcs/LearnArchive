package org.zhang.springsecurity.service.impl;

/**
 * @author: zhanghao
 * @date: 2022/7/22-22:38
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zhang.springsecurity.bean.LoginUser;
import org.zhang.springsecurity.bean.User;
import org.zhang.springsecurity.mapper.MenuMapper;
import org.zhang.springsecurity.mapper.UserMapper;

import java.util.List;

/**
 * @Description 自已实现UserDetailsService来从数据库进行用户信息查找
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @Description TODO
     * @return org.springframework.security.core.userdetails.UserDetails
     * @param username
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1.查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new RuntimeException("用户名不存在");
        }

        List<String> permessions = menuMapper.selectPermsByUserId(user.getId());

        //3.封装成UserDetails并返回
        return new LoginUser(user,permessions);
    }
}
