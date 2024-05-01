package test;

import bean.Order;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2021/11/9-14:05
 */
public class OrderDaoTest {

    @Test
    public void save() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(new Order("214356789567890", new Date(), new BigDecimal(89), 0, 1));
    }
}