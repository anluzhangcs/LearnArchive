package demo.response;

/**
 * @author: zhanghao
 * @date: 2021/10/30-11:03
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游");

        //请求重定向
        //方案1:①设置响应码 ②设置响应头的location为新地址
//        resp.setStatus(302);
//        resp.setHeader("location", "http://localhost:8080/04_Servlet/response2");

        //方案2:直接调用sendRedirect
        resp.sendRedirect("http://localhost:8080/04_Servlet/response2");

    }
}
