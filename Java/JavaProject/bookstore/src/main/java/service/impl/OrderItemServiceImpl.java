package service.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/9-13:30
 */

import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import service.OrderItemService;

/**
 * @Description
 */
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDao.save(orderItem);
    }
}
