package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-17:53
 */


/**
 * @Description
 */
public class Order {
    private String date;
    private double price;

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
