package demo1.test;

/**
 * @author: zhanghao
 * @date: 2021/9/11-11:56
 */

import demo1.utils.UtilForP2;

/**
 * @Description
 */
public class TestP2 {
    public static_test void main(String[] args) {
        UtilForP2 up = new UtilForP2();
        boolean flag = true;
        while (flag){
            int menu = up.start();
            switch (menu){
                case 1:
                    up.addCustomer();
                    break;
                case 2:
                    up.updateCustomer();
                    break;
                case 3:
                    up.deleteCustomer();
                    break;
                case 4:
                    up.showCustomer();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
