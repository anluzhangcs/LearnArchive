package service.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/9-13:29
 */

import bean.Order;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;

/**
 * @Description
 */
public class OrderSericeImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void saveOrder(Order order) {
        orderDao.save(order);
    }
}
