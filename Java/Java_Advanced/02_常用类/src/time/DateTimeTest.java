package time;

/**
 * @author: zhanghao
 * @date: 2021/9/27-14:56
 */

import org.junit.Test;

import java.util.Date;

/**
 * @Description 有关时间的类
 */
public class DateTimeTest {

    /*
     * @Description  有关时间的类
     * -java.lang.System
     *  返回当前时间距标准时间(1970年1月1日0时0分0秒)以毫秒为单位的时间戳
     *  long millis = System.currentTimeMillis();
     *
     * -java.util.Date
     *  构造器:
     *      Date()  空参构造器,创建当前时间的对象
     *      Date(long millis) 以long型变量为参数,创建指定时间戳的对象
     *  常用方法:
     *      getTime()   返回当前时间距标准时间(1970年1月1日0时0分0秒)以毫秒为单位的时间戳
     *      toString()  Date中重写了toString(),返回形如Mon Sep 27 15:32:04 CST 2021的字符串
     *
     *      |---java.sql.Date 继承了Date类,专为数据库打造
     *          构造器:没有空参构造器
     *              Date(long date) 以long型变量为参数,创建指定时间戳的对象
     *          常用方法:
     *              getTime()
     *              toString() 返回形如2021-09-27的字符串
     *
     * 问题1:java.util.Date(父类)如何转成java.sql.Date(子类)
     *      通过getTime()方法
     *      ①java.util.Date date = new java.util.Date();
     *      ②java.sql.Date date1 = new java.sql.Date(date.getTime())
     */
    @Test
    public void test1() {
        long millis = System.currentTimeMillis();
        System.out.println(millis);

    }

    @Test
    public void test2() {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);
        Date date1 = new Date(1632727924542l);
        System.out.println(date1);
        java.sql.Date date2 = new java.sql.Date(1632727924542l);
        System.out.println(date2);

        long time = date.getTime();
        java.sql.Date date3 = new java.sql.Date(time);
        System.out.println(date3);
    }
}
