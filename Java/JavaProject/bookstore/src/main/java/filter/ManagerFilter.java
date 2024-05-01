package filter;

/**
 * @author: zhanghao
 * @date: 2021/11/8-18:38
 */

import bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 配置后台管理过滤器，没有admin登录不允许进入
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        //获取session域中的user信息
        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            if ("admin".equals(user.getUsername())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                req.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
                return; //请求转发或重定向后一般结束方法，后面代码不执行
            }
        } else{
            //没有登录请求转发到登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
            return; //请求转发或重定向后一般结束方法，后面代码不执行
        }
    }
}
