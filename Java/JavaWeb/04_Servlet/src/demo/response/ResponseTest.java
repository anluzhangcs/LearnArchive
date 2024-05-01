package demo.response;

/**
 * @author: zhanghao
 * @date: 2021/10/30-10:26
 */

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 如何回传数据给浏览器
 */
public class ResponseTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决回传数据显示中文乱码问题,保持utf-8编码一致
        //方案1:设置服务器端的编码为utf-8,通过响应头告诉浏览器回传的数据类型和编码
//        System.out.println(resp.getCharacterEncoding()); //默认为ISO-8859-1
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("content-type", "text/html;charset=utf-8");

        //方案2:设置响应头的content-type==>同时保证浏览器和服务器编码为uft-8,须在获取流前设置
        resp.setContentType("text/html;charset=utf-8");

        //1.获取输出流,PrintWriter或者ServletOutputStream,二选一
//        ServletOutputStream outputStream = resp.getOutputStream(); //字节流,一般用于下载
        PrintWriter writer = resp.getWriter(); //字符流,常用,回传字符串

        //2.写入数据
        writer.write("你好,HttpServletResponse!!!");

    }
}
