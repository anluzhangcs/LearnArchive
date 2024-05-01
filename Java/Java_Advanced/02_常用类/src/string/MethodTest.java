package string;

/**
 * @author: zhanghao
 * @date: 2021/9/26-15:43
 */

import org.junit.Test;

/**
 * @Description String常用方法
 * 1.int length()       返回字符串长度
 * 2.boolean isEmpty()  判断字符串是否为空
 * 3.String toLowerCase()   返回小写的字符串
 * 4.String toUpperCase()   返回大写字符串
 * 5.boolean equals(str)    判断两个字符串是否相等
 * 6.boolean equalsIgnoreCase(str)  忽略大小写判断两个字符串是否相等
 * 7.int compareTo(str)
 *  比较两个字符串大小,逐个比较,只要不相等,立即返回差值,不用比较后面的;
 *  若两个字符串长度不等,前面的都相等,返回字符串长度之差
 * 8.String concat(str)     当前字符串连接str,相当于+,不常用
 * 9.char charAt(int index) 返回指定索引字符
 * 10.String substring(int startIndex) 返回当前字符串从指定索引开始的子串
 * 10.String substring(int startIndex,int endIndex)
 *      返回当前字符串从开始索引到结束索引的子串,包括start,不包括end.[)
 * 11.String trim()     返回去除开头和结尾空格的字符串,中间的不去
 *
 *
 *
 */
public class MethodTest {

    @Test
    /*
     *      regex为正则表达式,其实也可以作为普通字符串
     * 20.String replace(char oldchar,char newchar) 将所有旧字符替换为新字符
     * 21.String replace(CharSequence target,CharSequence s) 将所有target替换为s
     * 21.String replaceAll(String regex, String replacement) 将所有满足regex替换为replacement
     * 22.String replaceFirst(String regex, String replacement) 将第一个满足regex替换为replacement
     * 23.boolean matches(String regex) 判断字符串是否满足正则表达式
     * 24.String[] split(String regex)  以正则表达式将字符串分割
     * 25.String[] split(String regex, int limit) 以正则表达式将字符串分割为limit份,如果超过了,则多余的全放在最后一份
     */
    public void test3() {
        String s1 = "hello,world,hello,java";
        System.out.println(s1);
        System.out.println(s1.replace('h', 'm'));
        System.out.println(s1.replace("hello", "fuck"));
        System.out.println(s1.replaceAll("hello", "fuck"));
        System.out.println(s1.replaceFirst("hello", "fuck"));

        System.out.println(s1.matches("helloworld"));

        String[] strings = s1.split(",");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        String[] strings1 = s1.split(",", 3);
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

    }

    @Test
    /*
     * 12.boolean endsWith(String str) 是否以str结尾
     * 13.boolean startsWith(String str)     是否以str开头,从0开始
     * 14.boolean startsWith(String str,int toffset)从toffset开始,是否以str开头
     * 15.boolean contains(CharSequence s)  是否包含字符序列s
     *
     * 16.int indexOf(CharSequence s)   字符序列第一次出现的下标,找不到返回-1
     * 17.int indexOf(CharSequence s,int index) 从index开始,s第一次出现的位置
     * 18.int lastIndexOf(CharSequence s)  从末尾开始字符序列第一次出现的下标
     * 19.int lastIndexOf(CharSequence s,int index)从后往前开始字符序列第一次出现的下标
     * 注:lastIndexOf(s,index),index若为indexOf(s)的值,则lastIndexOf()也是这个值,很奇怪
     * CharSequence为字符序列接口,可以为char,也可以是String.
     */
    public void test2() {
        String s1 = "hellowoeld,hellojava";
        System.out.println(s1.length());
        System.out.println(s1.endsWith("java"));
        System.out.println(s1.startsWith("hello"));
        System.out.println(s1.startsWith("wo", 5));
        System.out.println(s1.contains("java"));

        System.out.println(s1.indexOf('a'));
        System.out.println(s1.indexOf("he", 11));
        System.out.println(s1.lastIndexOf("he"));
        System.out.println(s1.lastIndexOf("he", 11));
    }

    @Test
    public void test1(){
        String s1 = "Hello World";
        System.out.println(s1.length());
        System.out.println(s1.isEmpty());
        System.out.println(s1.charAt(7));
        String s2 = s1.toLowerCase();
        System.out.println(s2);
        String s3 = s1.toUpperCase();
        System.out.println(s3);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s3));

        String s4 = " hello world ";
        String s5 = s4.trim();
        System.out.println("--------" + s4 + "----------");
        System.out.println("--------" + s5 + "----------");

        String s6 = "abcefr";
        String s7 = "abc";
        System.out.println(s6.compareTo(s7));

        String s8 = s5.concat(s6);
        System.out.println(s8);

        String s9 = s8.substring(3);
        String s10 = s8.substring(3, 8);
        System.out.println(s9);
        System.out.println(s10);
    }
}
