package test;

import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2021/11/9-14:08
 */
public class OrderItemDaoTest {

    @Test
    public void save() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.save(new OrderItem(null,"java从入门到放弃",1,new BigDecimal(80),new BigDecimal(80),"214356789567890"));
    }
}