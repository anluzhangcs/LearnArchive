package demo.context;

/**
 * @author: zhanghao
 * @date: 2021/10/29-18:00
 */


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description javax.servlet.ServletContext
 *  -它是一个接口
 *  -表示Servlet上下文,是一个域对象
 *  -一个JavaWeb工程只有一个ServletContext对象,且每个Servlet都可以获取
 *  -web工程部署时创建,停止时销毁
 *
 *  作用:
 *      getContextPath() 获取当前工程路径
 *      getRealPath("/") /映射到Idea JavaWeb项目的web\目录下,因此它获取的是web工程部署后的绝对路径
 *      setAttribute,getAttribute   设置和获取参数
 *      getInitParameter  获取context-param参数,这种参数属于整个web工程,而不是Servlet中的init-param
 */
public class ContextTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String contextPath = context.getContextPath();
        String realPath = context.getRealPath("/");
        context.setAttribute("user", "root");
        Object user = context.getAttribute("user");
        String initParameter = context.getInitParameter("user");

        System.out.println(contextPath);
        System.out.println(realPath);
        System.out.println(user);


    }
}
