package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/7-11:17
 */

import bean.Book;
import bean.Cart;
import bean.CartItem;
import com.google.gson.Gson;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 购物车Servlet
 */
public class CartServlet extends BaseServlet {
    private Cart cart = new Cart();
    private BookService bookService = new BookServiceImpl();

    /*
     * @Description  展示商品
     * @param req
     * @param resp
     * @return  void
     */
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
    }

    /*
     * @Description  添加商品到购物车
     * @param req
     * @param resp
     * @return  void
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseStr(req.getParameter("id"), 0);
        // 调用 bookService.queryBookById(id):Book 得到图书的信息
        Book book = bookService.queryOne(id);
        // 把图书信息，转换成为 CartItem 商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用 Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //将最后一个添加的商品名称保存到session域中
        req.getSession().setAttribute("lastItemName",cartItem.getName());

        // 重定向回请求前地址栏的地址
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /*
     * @Description  ajax请求添加购物车
     * @param req
     * @param resp
     * @return  void
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseStr(req.getParameter("id"), 0);
        // 调用 bookService.queryBookById(id):Book 得到图书的信息
        Book book = bookService.queryOne(id);
        // 把图书信息，转换成为 CartItem 商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用 Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //将最后一个添加的商品名称保存到session域中
        req.getSession().setAttribute("lastItemName",cartItem.getName());

        //6.回传信息:商品名称,购物车总数量
        Map<String, Object> map = new HashMap<>();
        map.put("itemName", cartItem.getName());
        map.put("totalCount", cart.getTotalCount());
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要删除商品的id
        Integer id = WebUtils.parseStr(req.getParameter("id"), 0);

        //2.获取session中的cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //3.调用cart对象中的deleteItem方法
        cart.deleteItem(id);

        // 重定向回请求前地址栏的地址
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取要修改商品id,商品数量
        Integer id = WebUtils.parseStr(req.getParameter("id"), 0);
        Integer count = WebUtils.parseStr(req.getParameter("count"), 1);

        //2.获取session域中的cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //3.调用cart对象中的update方法
        cart.updateCount(id,count);

        // 重定向回请求前地址栏的地址
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取session中的cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();

        // 重定向回请求前地址栏的地址
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
