package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/11-9:31
 */

/**
 * @Description
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[10];
    }

    public void addCustomer(String f,String l){
        Customer customer = new Customer(f, l);

//        numberOfCustomer += 1;
//        //会造成每次添加用户时就会重新创建一个客户数组,customers的创建可以放在构造器中
////        customers = new Customer[numberOfCustomer];
//        customers[numberOfCustomer-1] = customer;
        customers[numberOfCustomer++] = customer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index){
        return customers[index];
    }
}
