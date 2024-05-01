package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/27-18:36
 */

import java.util.Arrays;

/**
 * @Description 对字符串中字符进行自然顺序排序。
 */
public class Test5 {
    public static void main(String[] args) {
        String str = "afhkldeb";
        String res = fun(str);
        System.out.println(res);
    }

    static String fun(String str) {
        char[] arr = str.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i] > arr[j]){
//                    char ch = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = ch;
//                }
//            }
//        }
        Arrays.sort(arr);
        String res = new String(arr);
        return res;
    }
}
