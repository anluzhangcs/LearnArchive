package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/19-15:31
 */

import java.util.Scanner;

/**
 * @Description 手动抛出异常
 *  throw和throws的区别
 *      -throw是抛阶段,一般Java在代码出现问题时会自动抛出异常,throw就是手动抛出异常,如在if-else语句中
 *      -throws是抓阶段,是处理异常的方式
 */
public class ThrowTest {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        int sno = scanner.nextInt();
        student.setSno(sno);
        System.out.println(sno);
    }
}

class Student{
    String name;
    int sno;

    public void setName(String name) {
        this.name = name;
    }

    public void setSno(int sno) {
        if (sno > 0){
            this.sno = sno;
        } else{
            //传统方式
//            System.out.println("您输入的数据有误");
            //throw异常
            throw new MyException("为负数");
        }
    }
}