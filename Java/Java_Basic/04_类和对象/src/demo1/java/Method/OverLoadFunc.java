package demo1.java.Method;

/**
 * @author: zhanghao
 * @date: 2021/9/10-9:11
 */

/**
 * @Description 方法重载
 */
public class OverLoadFunc {

    public void getSum(int x,int y){
        System.out.println(1);
    }

    public void getSum(double x,double y){
        System.out.println(2);
    }

    public void getSum(int x,double y){
        System.out.println(3);
    }

    public int getSum(double x,int y){return 4;}
}
