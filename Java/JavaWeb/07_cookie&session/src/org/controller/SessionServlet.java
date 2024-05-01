package org.controller;

/**
 * @author: zhanghao
 * @date: 2021/11/5-19:07
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description
 */
public class SessionServlet extends BaseServlet {


    /*
     * @Description  Session的获取或者创建
     * @param req
     * @param resp
     * @return  void
     */
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); //可以创建或者获取Session
        String id = session.getId(); //获取Session唯一标识id
        //判断session是新创建的还是获取之前的.true为新创建,false反之
        boolean isNew = session.isNew();

        resp.getWriter().write("当前会话Session的id是"+id);
        resp.getWriter().write("当前会话是否新创建的:"+isNew);
    }

    protected void sessionLifeTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); //可以创建或者获取Session

        //获取当前Session的默认超时时长,由Idea当前工程整合Tomcat中的web.xml配置决定,默认为30分钟
        int maxInactiveInterval = session.getMaxInactiveInterval();

        //设置当前session的生命周期为多少秒.负数为永不销毁(极少使用)
        session.setMaxInactiveInterval(3);

        //设置当前session立即销毁
        session.invalidate();
    }
}
