package org.zhang.springsecurity.service.impl;

/**
 * @author: zhanghao
 * @date: 2022/7/23-21:44
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zhang.springsecurity.bean.LoginUser;
import org.zhang.springsecurity.bean.User;
import org.zhang.springsecurity.service.LoginService;
import org.zhang.springsecurity.utils.JwtUtil;
import org.zhang.springsecurity.utils.RedisCache;
import org.zhang.springsecurity.utils.ResponseResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description 实现登录业务逻辑
 */

@Service
public class LoginServiceImpl implements LoginService {

    //认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;

    //RedisCache
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        /*
        1.authenticationManager调用authenticate方法,传入一个Authentication
            进行验证,验证成功后封装为Authentication对象返回
         */
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken
                        (user.getUserName(), user.getPassword()));

        //2.判断authentication是否为空 NULL代表验证失败
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        //3.登录成功 获取用户id并以此生成一个jwt
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        //4.
        redisCache.setCacheObject("login:"+userId, loginUser);


        //返回结果
        Map<String, String> data = new HashMap<>();
        data.put("token", jwt);
        return new ResponseResult(200,"登陆成功",data);
    }

    /*
    * 退出登录逻辑
    * */
    @Override
    public ResponseResult logout() {
        //经过jwt过滤器已经取得userid 且一次请求是同一个SecurityContextHolder
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        //获取authentication中用户信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();

        //根据userid从Redis中删除
        redisCache.deleteObject("login:" + userid);

        return new ResponseResult(200, "退出登录");
    }
}
