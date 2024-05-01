package test;

import bean.Cart;
import bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2021/11/8-11:14
 */
public class CartTest {


    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }

    @Test
    public void getTotalCount() {
    }

    @Test
    public void getTotalPrice() {
    }

    @Test
    public void getItems() {
    }
}