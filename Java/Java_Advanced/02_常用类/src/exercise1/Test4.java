package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/27-18:34
 */

/**
 * @Description 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 *
 */
public class Test4 {
    public static void main(String[] args) {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(fun(str1, str2));
    }

    static String fun(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = str1.length() >= str2.length()?str1:str2;
            String minStr = str1.length() < str2.length()?str1:str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length-i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }

            }
        }
        return null;
    }
}
