package org.zhang.filter;

/**
 * @author: zhanghao
 * @date: 2021/11/7-10:01
 */


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description Filter过滤器,Javax.servlet.Filter
 *  -Filter是JavaEE的接口,规范
 *  -Filter过滤器是JavaWeb三大组件之一
 *  -Filter用于拦截请求(常用),过滤响应(极少用)
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //getFilterName,获取配置的filter别名
        System.out.println(filterConfig.getFilterName());

        //getInitParameter,获取配置的初始化参数,比较常用
        System.out.println(filterConfig.getInitParameter("user"));

        //获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /*
     * @Description  实现Filter接口中最重要的方法,就是这个方法拦截请求
     * @param request
     * @param response
     * @param chain
     * @return  void
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //先对请求进行强转
        HttpServletRequest req = (HttpServletRequest) request;
        //获取Session域中user信息
        String username = (String) req.getSession().getAttribute("user");

        if (username == null) { //session域中没有信息,没有权限,请求拦截
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } else{ //有权限
            //继续执行该请求
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
