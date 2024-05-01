package demo1.test;

/**
 * @author: zhanghao
 * @date: 2021/9/11-13:27
 */

import java.util.Scanner;

/**
 * @Description Scanner的基本使用
 * next()   读取字符串，忽略空格、Tab键、enter键，以enter键结束
 * nextLine()   读取字符串，不忽略空格、Tab键、enter键，以enter键结束
 * 注意事项：
 *      在next(),nextInt,nextDouble()...之后使用nextLine(),会出现读取到的为空格
 *      scanner.nextLine();读取换行，解决上述问题
 */
public class ScannerTest {
    public static_test void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
        scanner.nextLine();
        System.out.println(scanner.nextLine());
        System.out.println(scanner.next());
    }

}
