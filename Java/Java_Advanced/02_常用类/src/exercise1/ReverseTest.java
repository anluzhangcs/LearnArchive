package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/27-18:16
 */


/**
 * @Description 将一个字符串进行反转。将字符串中指定部分进行反转。
 *              比如“abcdefg”反转为”abfedcg”
 */
public class ReverseTest {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String res = myReverse(s1, 2, 5);
        System.out.println(res);

    }

    static String myReverse(String str,int start,int end) {
        char[] arr = str.toCharArray();
        StringBuffer s = new StringBuffer();
        int flag = (start + end+1)/2;
        for (int i = start; i <flag ; i++) {
            char ch = arr[i];
            arr[i] = arr[end];
            arr[end] = ch;
            end--;
        }
        String res = new String(arr);
        return res;
    }
}
