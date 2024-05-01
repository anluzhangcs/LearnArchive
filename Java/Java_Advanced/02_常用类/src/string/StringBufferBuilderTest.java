package string;

/**
 * @author: zhanghao
 * @date: 2021/9/27-10:13
 */

import org.junit.Test;

/**
 * @Description String StringBuffer StringBuilder
 */
public class StringBufferBuilderTest {
    
    /*
     * @Description  StringBuffer /StringBuilder常用方法
     * 1.StringBuffer append(xxx)   向底层数组中添加内容,返回this
     * 2.StringBuffer delete(int start, int end) 删除[start,end)的数组内容
     * 3.StringBuffer insert(int offset, xxx) 从offset开始插入数据
     * 4.StringBuffer replace(int start, int end, String str) 替换[start,end)的数组内容为str
     * //注:注意区分String的replace()方法
     * 5.void setCharAt(int index, char ch) 替换指定下标的字符
     * 6.StringBuffer reverse() 反转字符串
     */
    @Test
    public void test2() {
        StringBuffer str = new StringBuffer(20);
        str.append("helloworld");
        System.out.println(str);
        str.delete(3, 5);
        System.out.println(str);
        str.insert(3, "lo");
        str.replace(0, 5, "fuck");
        System.out.println(str);
        str.setCharAt(1, 'o');
        System.out.println(str);
        str.reverse();
        System.out.println(str);

    }
    
    /*
     * 三者的异同
     *  String: 不可变字符序列,底层存储数据的是final char[] value;
     *  StringBuffer:可变的字符序列,底层存储数据的是char[] value,线程安全;
     *  StringBuilder:可变的字符序列,底层存储数据的是char[] value;
     *  注:StringBuffer和StringBuilder都是继承AbstractStringBuilder类,只是线程安全有差别
     *
     *  源码分析:为什么String不可变,其他两个可变
     *  String s1 = new String(); //new char[0];
     *  String s1 = new String("abc") //new char[3]
     *  //new char[capacity] capacity底层数组容量为16
     *  StringBuffer s2 = new StringBuffer();
     *  StringBuffer s2 = new StringBuffer(String str) //capacity=str.length()+16
     *  //StringBuilder同StringBuffer
     *  StringBuilder s3 = new StringBuilder();
     *
     *  问题1:StringBuffer和StringBuilder的长度问题
     *  String类的长度为value.length(),而另两个的长度为count,不是容量,是内容的长度
     *
     *  问题2:StringBuffer的扩容问题???
     *      -StringBuffer创建对象,如果构造器StringBuffer(String str)首先会super(capacity)创建char[] value
     *      -然后会append(str),然后append方法里又会调用super.append(str)
     *      -如果count+str.length()>capacity,就会创建一个新数组,一般情况为旧数组capacity*2+2,若果还不够,就直接创建count+str.length()
     *  ==>开发中,少使用String,效率低.可以根据线程安全情况选择StringBuffer或StringBuilder.若大致知道字符串的长度,可以使用
     *      StringBuffer(int capacity)构造对象,避免出现扩容问题降低效率
     */
    @Test
    public void test1() {
        String s1 = new String();
        StringBuffer s2 = new StringBuffer();
        System.out.println(s2.length());
        s2.append("123");
        System.out.println(s2.length());
        StringBuilder s3 = new StringBuilder(20);
        s3.append("helloworld");
        System.out.println(s3);
    }

}
