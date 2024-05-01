package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/27-17:22
 */


/**
 * @Description 实现trim()方法
 */
public class TrimTest {
    public static void main(String[] args) {
        String s1 = "   he   llo w or ld   ";
        System.out.println("---------"+s1+"---------");
        String s2 = mytrim(s1);
        System.out.println("----------"+s2+"---------");
        System.out.println(s1.length());
        System.out.println(s2.length());
    }

    static String mytrim(String str) {
        char[] arr = str.toCharArray();
        StringBuffer s = new StringBuffer();

        int start=0,end=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' '){
                start = i;
                break;
            }
        }for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i] != ' '){
                end = i;
                break;
            }
        }
        s.append(arr, start, end - start + 1);
        return s.toString();
    }
}
