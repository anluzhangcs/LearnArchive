package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/3-18:02
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
 * @Description 处理Book模块的业务
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();


    /*
     * @Description  获取Page对象并存到request域中
     * @param req
     * @param resp
     * @return  void
     */
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
        bookPage.setUrl("manager/book?action=page");

        //7.保存到request域对象中,请求转发到book_manager.jsp页面
        req.setAttribute("page", bookPage);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    /*
     * @Description  添加图书
     * @param book
     * @return  void
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数并封装为对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用service层的添加操作
        bookService.addBook(book);

        //3.重定向到查询请求
        resp.sendRedirect("/bookstore/manager/book?action=page&pageNumber="+req.getParameter("pageNumber"));
    }

    /*
     * @Description  删除图书
     * @param req
     * @param resp
     * @return  void
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        //1.获取要删除的id
        Integer id = WebUtils.parseStr(req.getParameter("id"), 0);
        //2.调用业务层进行删除
        bookService.deleteBook(id);
        //3.重定向到查询请求,注意要用重定向,且重定向到查询请求,否则没有数据
        resp.sendRedirect("/bookstore/manager/book?action=page&pageNumber="+req.getParameter("pageNumber"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect("/bookstore/manager/book?action=page&pageNumber="+req.getParameter("pageNumber"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        //1.获取请求参数中的id
        Integer id = WebUtils.parseStr(req.getParameter("id"), 0);
        //2.查询该id的图书信息
        Book book = bookService.queryOne(id);
        //3.将book保存到request域中,转发到图书编辑页面,这样就可以回显图书信息了
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        book = bookService.queryOne(book.getId());
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        List<Book> books = bookService.queryList();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}
