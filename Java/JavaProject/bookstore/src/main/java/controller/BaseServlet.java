package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/3-14:16
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Description 对各个模块的进一步抽取
 *  重写doPost()方法,使得对于不同的请求,通过反射执行对应的操作
 *  然后对每一个模块,都继承这个BaseServlet而不是HttpServlet,不用每一个模块的Servlet都需要通过
 *  反射执行方法
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使得它可以接收get请求,在调用doPost方法,同样通过反射执行对应的操作
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取请求的action的值,即要完成什么功能
        String action = req.getParameter("action");
        try {
            //2.通过反射找到action值所对应的处理方法
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //3.执行该方法,this为当前对象
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
