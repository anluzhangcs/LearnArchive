package demo.request;

/**
 * @author: zhanghao
 * @date: 2021/10/29-21:10
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Description HttpServletRequest测试
 */
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * @Description  HttpServletRequest
         *  HttpServletRequest对象封装了请求的所有信息
         *  注意点:
         *      ①若参数的值有多个,如复选框,则需要调用getParameterValues()返回一个String[]
         *      ②post请求中文可能乱码,解决方法:
         *          req.setCharacterEncoding("utf-8"),需要在获取参数之前设置,否则无效
         */

//        req.setCharacterEncoding("utf-8");

        System.out.println(req.getHeader("Host")); //获取请求头中的某个键的值
        System.out.println(req.getMethod()); //获取请求方式
        System.out.println(req.getRequestURI()); //获取请求资源路径
        System.out.println(req.getRequestURL()); //获取请求url,即地址栏
        System.out.println(req.getRemoteHost()); //获取请求的

        //获取请求参数,根据name属性
        System.out.println(req.getParameter("username"));
        //若参数的值有多个,如复选框,则需要调用getParameterValues()返回一个String[]
        System.out.println(Arrays.toString(req.getParameterValues("hobby")));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        System.out.println(req.getHeader("Host")); //获取请求头中的某个键的值
        System.out.println(req.getMethod()); //获取请求方式
        System.out.println(req.getRequestURI()); //获取请求资源路径
        System.out.println(req.getRequestURL()); //获取请求url,即地址栏
        System.out.println(req.getRemoteHost()); //获取发送请求客户端的ip地址

        //获取请求参数,根据name属性
        System.out.println(req.getParameter("username"));
        //若参数的值有多个,如复选框,则需要调用getParameterValues()返回一个String[]
        System.out.println(Arrays.toString(req.getParameterValues("hobby")));

    }
}
