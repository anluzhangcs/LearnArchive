package demo.request;

/**
 * @author: zhanghao
 * @date: 2021/10/29-22:09
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求参数(可选)
        System.out.println(req.getParameter("username"));

        //2.获取Servlet1中传递的数据(可选)
        System.out.println(req.getAttribute("key"));

        //3.处理请求并响应
        System.out.println("请求被响应了");
    }
}
