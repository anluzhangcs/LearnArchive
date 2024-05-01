package org.zhang.springsecurity.hander;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.zhang.springsecurity.utils.ResponseResult;
import org.zhang.springsecurity.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Zhanghao
 * @date: 2022/7/26-19:51
 * @Description 自定义认证异常处理器
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    /**
     * @Description 统一响应数据为json
     * @return void
     * @param request
     * @param response
     * @param authException 认证失败异常对象
     **/
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "认证失败请重新登录");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
