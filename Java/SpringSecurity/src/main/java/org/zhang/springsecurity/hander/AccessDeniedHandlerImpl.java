package org.zhang.springsecurity.hander;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.zhang.springsecurity.utils.ResponseResult;
import org.zhang.springsecurity.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Zhanghao
 * @date: 2022/7/26-20:01
 * @Description 自定义授权失败处理器
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    /**
     * @Description 统一响应为json
     * @return void
     * @param request
     * @param response
     * @param accessDeniedException
     **/
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "权限不足");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
