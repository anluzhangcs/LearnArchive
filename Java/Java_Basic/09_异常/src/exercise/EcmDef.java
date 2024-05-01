package exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/19-15:59
 */

//import demo1.ArraysTest;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description
 */
public class EcmDef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x= 0;
        int y = 0;
        try {
            x = scanner.nextInt();
            y = scanner.nextInt();
            method1(x,y);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (ArithmeticException e){
            e.printStackTrace();
        }

    }

    static void method1(int x,int y){
        int res ;
        if (x>0 || y>0){
            res = x/y;
            System.out.println(res);
        } else{
            throw new EcDefException("负数错误");
        }
    }
}
