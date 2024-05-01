package demo.request;

/**
 * @author: zhanghao
 * @date: 2021/10/29-22:02
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 请求的转发之第一站
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求参数
        System.out.println(req.getParameter("username"));

        //2.若有信息要传递给另一个Servlet,则通过域数据(可选)
        req.setAttribute("key", "Servlet1");

        //3.获取请求调度对象
        // /servlet2为转发请求,/表示的是http://ip:port:/工程路径/,映射到wen目录下
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        //4.进行转发,参数为这个servlet的req,resp==>两个servlet共享请求和响应
        requestDispatcher.forward(req,resp);
    }
}
