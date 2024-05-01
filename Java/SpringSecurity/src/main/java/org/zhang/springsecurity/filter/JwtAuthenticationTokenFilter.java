package org.zhang.springsecurity.filter;

/**
 * @author: zhanghao
 * @date: 2022/7/24-22:06
 */

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.zhang.springsecurity.bean.LoginUser;
import org.zhang.springsecurity.utils.JwtUtil;
import org.zhang.springsecurity.utils.RedisCache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Description 创建自定义过滤器继承OncePerRequestFilter
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //1.从header中获取token
        String token = request.getHeader("token");

        //2.判断token不为空不为""
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        //3.解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //4.从Redis中根据userid查找
        LoginUser loginUser = redisCache.getCacheObject("login:" + userid);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }

        //5.将loginuser存入SpringSecurityContext
        //TODO 将权限信息存入authentication
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}
