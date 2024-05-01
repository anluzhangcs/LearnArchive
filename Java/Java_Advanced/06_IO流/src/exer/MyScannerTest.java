package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/12-13:38
 */

/**
 * @Description
 */
public class MyScannerTest {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(System.in);
        String next = scanner.next();
        System.out.println(next);
        scanner.close();
    }
}
