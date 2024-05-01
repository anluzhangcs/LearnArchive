package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/4-17:54
 */

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description 前台的图书模块 ---controller层 MVC的C
 */
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Book> bookPage = new Page<>();

        //2.获取请求中的pageSize;若没有,则给默认值为Page模型中的常量
        Integer pageSize = WebUtils.parseStr(req.getParameter("pageSize"), Page.PAGE_SIZE);
        bookPage.setPageSize(pageSize);

        //3.获取总记录数
        Integer itemCount = bookService.queryCount();
        bookPage.setItemCount(itemCount);

        //4.获取总页数 总记录数/pageSize,若有余,则加1
        Integer pageTotal = itemCount % pageSize > 0 ? (itemCount / pageSize) + 1 : itemCount / pageSize;
        bookPage.setPageTotal(pageTotal);

        //1.获取请求中的pageNumber;若没有,则给默认值为1,即首页
        Integer pageNumber = WebUtils.parseStr(req.getParameter("pageNumber"), 1);
        bookPage.setPageNumber(pageNumber);
        //注:pageNumber要在pageTotal之后设置,这样服务器页码校验才会生效
        pageNumber = bookPage.getPageNumber(); //重新获取pageNumber

        //5.获取当前页的记录.开始索引begin=(pageNumber-1)*pageSize
        Integer begin = (pageNumber-1)*pageSize;
        List<Book> items = bookService.queryItems(begin, pageSize);
        bookPage.setItems(items);

        //设置当前模块分页的url
        bookPage.setUrl("client/book?action=page");

        //7.保存到request域对象中,请求转发到book_manager.jsp页面
        req.setAttribute("page", bookPage);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求中的pageNumber;若没有,则给默认值为1,即首页
        Integer pageNumber = WebUtils.parseStr(req.getParameter("pageNumber"), 1);

        //2.获取请求中的pageSize;若没有,则给默认值为Page模型中的常量
        Integer pageSize = WebUtils.parseStr(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //获取min，max价格区间
        Integer min = WebUtils.parseStr(req.getParameter("min"), 0);
        Integer max = WebUtils.parseStr(req.getParameter("max"), Integer.MAX_VALUE);

        //3.调用业务层操作获取page
        Page<Book> bookPage = bookService.getPageByPrice(pageNumber, pageSize, min, max);

        //设置当前模块分页的url
        StringBuilder stringBuilder = new StringBuilder("client/book?action=pageByPrice");
        stringBuilder.append("&min=").append(min).append("&max=").append(max);
        bookPage.setUrl(stringBuilder.toString());

        //7.保存到request域对象中,请求转发到book_manager.jsp页面
        req.setAttribute("page", bookPage);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
