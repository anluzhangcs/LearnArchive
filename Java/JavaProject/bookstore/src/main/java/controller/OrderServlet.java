package controller;

/**
 * @author: zhanghao
 * @date: 2021/11/9-13:25
 */

import bean.*;
import service.OrderItemService;
import service.OrderService;
import service.impl.OrderItemServiceImpl;
import service.impl.OrderSericeImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @Description Order模块servlet
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderSericeImpl();
    private OrderItemService orderItemService = new OrderItemServiceImpl();

    /*
     * @Description  生成订单.即要生成订单,还有订单明细
     * @param req
     * @param resp
     * @return  void
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取session域中购物车信息和用户信息
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (cart == null || cart.getItems().size() == 0) { //购物车为null或商品数量为0
            resp.sendRedirect(req.getContextPath()); //重定向到首页
            return;
        }
        if (user == null) { //没有登陆
            resp.sendRedirect("/bookstore/pages/user/login.jsp");
            return;
        }

        //创建订单和订单明细
        String orderId = "" + System.currentTimeMillis() + user.getId();
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, 1);
        orderService.saveOrder(order); //调用service层方法保存订单
        Map<Integer, CartItem> items = cart.getItems(); //获取商品项Map
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) { //遍历
            CartItem cartItem = entry.getValue();
            //每一项都与需要orderId,所以创建订单要放前面
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemService.saveOrderItem(orderItem); //保存订单明细
        }

        //跳转页面,回显数据
        req.setAttribute("orderId", orderId);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

    }
}
