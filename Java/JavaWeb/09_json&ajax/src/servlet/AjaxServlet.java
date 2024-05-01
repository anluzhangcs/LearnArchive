package servlet;

/**
 * @author: zhanghao
 * @date: 2021/11/8-22:16
 */

import bean.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Description
 */
public class AjaxServlet extends BaseServlet {

    /*
     * @Description  原生Ajax请求
     * @param req
     * @param resp
     * @return  void
     */
    protected void ajax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void serialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取数据
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println(req.getParameter("password"));
        String[] checks = req.getParameterValues("check");
        System.out.println(Arrays.toString(checks));

        //回传数据,json字符串
        Person person = new Person("张三", 21);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

}
