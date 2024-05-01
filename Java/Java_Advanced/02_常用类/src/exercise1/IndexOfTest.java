package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/27-18:24
 */

/**
 * @Description 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
public class IndexOfTest {
    public static void main(String[] args) {
        String str = "abkkcadkabkebfkabkskab";
        System.out.println(fun(str, "ka"));
    }

    static int fun(String str,String s) {
        int count = 0;
        int i = 0;
        while (true) {
            int tmp = str.indexOf(s, i);
            if (tmp >= 0) {
                count++;
                i = tmp + s.length();
            } else{
                break;
            }
        }
        return count;
    }
}
