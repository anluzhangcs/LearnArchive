package object_class;

/**
 * @author: zhanghao
 * @date: 2021/9/12-11:19
 */

/**
 * @Description
 */
public class Order {
    private int orderId;
    private String orderName;

    @Override
    public boolean equals(Object obj) {
        //首先判断地址值是否相同，相同则直接返回true
        if (this == obj){
            return true;
        }
        //判断obj是否能指向Order
        if (obj instanceof Order){
            //能则强转为Order
            Order order = (Order)obj;
            //注意引用类型要用equals()
            return this.orderId==order.orderId && this.orderName.equals(order.orderName);
        } else{
            return false;
        }
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
