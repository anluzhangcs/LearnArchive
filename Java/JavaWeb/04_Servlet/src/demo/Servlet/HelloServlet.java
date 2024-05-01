package demo.Servlet;

/**
 * @author: zhanghao
 * @date: 2021/10/29-15:30
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description 第一个Servlet程序
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        //Servlet构造
        System.out.println("Servlet构造");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //Servlet初始化
        System.out.println("Servlet初始化");

        /*
         * @Description  ServletConfig类
         *  -Servlet配置信息类,存放Servlet的配置信息
         *  -当一个Servlet程序被创建时,就会有一个对应的ServletConfig对象
         *      作用:
         *      获取Servlet别名
         *      String getServletName();
         *      获取ServletContext对象
                ServletContext getServletContext();
                获取初始化参数
                String getInitParameter(String var1);
                获取初始化参数的参数名
                Enumeration<String> getInitParameterNames();
         *
         */
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        System.out.println(servletConfig.getInitParameter("user"));
        System.out.println(servletConfig.getInitParameter("password"));
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //Servlet程序中用于响应请求的方法
//        System.out.println("HelloServlet程序响应了");
        /*
         * @Description  请求的分发处理
         *  1.先将ServletRequest转换为HttpServletRequest,其中有getMethod()获取请求方式
         *  2.getMethod获取请求方式
         *  3.分发处理
         */
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    private void doPost() {
        System.out.println("Post请求");
    }

    private void doGet() {
        System.out.println("Get请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //Servlet程序销毁
        System.out.println("Servlet程序销毁");
    }
}
