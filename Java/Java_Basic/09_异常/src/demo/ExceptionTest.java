package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/19-9:54
 */

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @Description
 */
public class ExceptionTest {
    @Test
    //ArithmeticException:算术错误异常,如除数为0
    public void test1(){
        int x= 10;
        int y=2;
        System.out.println(x/y);
    }

    @Test
    //NullPointerException:空指针异常,一般出现在对象或数组中
    public void test2(){
        String str = "abc";
//        str = null;
        System.out.println(str.length());
    }

    @Test
    //下标越界异常:IndexOutOfBoundsException
    public void test3(){
        //数组下标越界异常:ArrayIndexOutOfBoundsException
        int[] arr = new int[5];
        System.out.println(arr[4]);

        //字符串下标越界异常:StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(2));
    }

//    @Test
////    //ClassCastException:类型转换异常
////    public void test4(){
////        Object obj = new Date();
////        String str  = (String)obj;
////    }

    @Test
    //输入不匹配异常:InputMismatchException
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
        scanner.close();
    }

    @Test
    //
    public void test6(){
        Scanner scanner = new Scanner(System.in);
        int num =Integer.parseInt(scanner.next()) ;
        System.out.println(num);
    }
}
