package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/3-13:55
 */

import bean.User;
import com.google.gson.Gson;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @Description 抽取单个功能==>负责用户模块的所有功能
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();


    /*
     * @Description  注销功能
     * @param req
     * @param resp
     * @return  void
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.清除session中的用户信息或者直接销毁session
        req.getSession().invalidate();

        //2.请求重定向到首页
        resp.sendRedirect(req.getContextPath());

    }

    /*
     * @Description  登录功能
     * @param req
     * @param resp
     * @return  void
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将请求参数一次性封装到对象中,减少重复的的获取参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        int res = userService.login(user);
        switch (res) {
            case -1:
                //回显错误信息和用户名
                req.setAttribute("msg","用户名不存在");
                req.setAttribute("username", req.getParameter("username"));
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
                break;
            case 0:
                req.setAttribute("msg","用户名或密码错误");
                req.setAttribute("username", req.getParameter("username"));
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
                break;
            case 1:
                //将用户登录信息保存到session域中,便于回显用户信息
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
                break;
        }
    }

    /*
     * @Description  注册功能
     * @param req
     * @param resp
     * @return  void
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        String code = req.getParameter("code");

        //获取保存在session域中的验证码并清除
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);//及时删除这个验证码


        //2.判断验证码和服务器提供的是否一致
        if (token.equalsIgnoreCase(code)) {

            if (userService.regist(user)) {

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            } else {
                //回显错误信息,用户名,邮箱
                req.setAttribute("msg", "用户名已存在或邮箱已绑定");
                req.setAttribute("username", req.getParameter("username"));
                req.setAttribute("email", req.getParameter("email"));
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        } else{

            //回显错误信息,用户名,邮箱
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", req.getParameter("username"));
            req.setAttribute("email", req.getParameter("email"));

            //验证码不正确,请求转发到注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /*
     * @Description  ajax请求验证用户名是否存在
     * @param req
     * @param resp
     * @return  void
     */
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        boolean res = userService.regist(user);

        //将结果封装为map
        Map<String, Object> map = new HashMap<>();
        map.put("exist", res);

        //将map转换为json字符串
        Gson gson = new Gson();
        String jsonString = gson.toJson(map);

        //将json传回客户端
        resp.getWriter().write(jsonString);

    }
}
