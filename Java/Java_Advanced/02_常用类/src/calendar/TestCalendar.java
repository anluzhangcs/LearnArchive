package calendar;

/**
 * @author: zhanghao
 * @date: 2021/10/1-10:24
 */

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description java.util.Calendar
 *  -Calendar是一个抽象类
 *  -getInstance()方法获取当前时间实例 java.util.GregorianCalendar
 *  -常用全局常量
 *      DAY_OF_MONTH、DAY_OF_WEEK...
 *  -常用方法
 *      getTime()   返回值为Date,返回当前时间的日期
 *      setTime(Date date) 以date设置时间
 *      get(int filed)       获取全局常量的信息
 *      set(int filed,int amount) 设置全局常量的信息
 *      add(int filed,int amount) 设置全局常量的信息
 */
public class TestCalendar {
    @Test
    public void tset1() {
        Calendar calendar = Calendar.getInstance();
        //getClass()返回创建这个实力对象的类
        System.out.println(calendar.getClass());

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.MONTH));
        Date date = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK,3);
        date = calendar.getTime();
        System.out.println(date);
    }



}
