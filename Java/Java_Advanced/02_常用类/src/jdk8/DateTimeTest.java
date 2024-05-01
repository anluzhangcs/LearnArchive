package jdk8;

/**
 * @author: zhanghao
 * @date: 2021/10/1-14:14
 */

/*
 * @Description  JDK8中新引入的
 */
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;


public class DateTimeTest {

    /*
     * @Description  java.time.format.DateTimeFormatter
     *  -类似于SimpleDateFormat
     *  -创建方式
     *      (默认)Using predefined constants, such as ISO_LOCAL_DATE
            (本地)Using localized styles, such as long or medium
            (自定义)Using pattern letters, such as uuuu-MMM-dd ==>常用
     *  -DateTimeFormatter 与LocalTime,LocalDate,LocalDateTime配套使用,
     *      也要一一对应
     *  -格式化
     *      format  Localxxx ==> String
     *      public String format(TemporalAccessor temporal)
     *      TemporalAccessor是接口,LocalXXX都实现了
     *
     *      parse   String   ==> LocalXXX
     *      public TemporalAccessor parse(CharSequence text)
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        //方式1
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String format = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);
        String str = "2021-10-01T16:28:05.05";
        TemporalAccessor accessor = formatter.parse("2021-10-01T16:28:05.05");
        System.out.println(accessor);

        //方式2
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String format1 = formatter1.format(localDate);
        System.out.println(format1);
        String str1 = "21-10-2";
        TemporalAccessor accessor1 = formatter1.parse(str1);
        System.out.println(accessor1);

        //方式3
        //注:这里的时间是12小时制,str大于12是parse会抛出异常
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format2 = formatter2.format(localDateTime);
        System.out.println(format2);
        String str2 = "2021-10-01 04:38:45";
        TemporalAccessor accessor2 = formatter2.parse(str2);
        System.out.println(accessor2);
    }

    /*
     * @Description  java.time.Instant
     *  -创建方式
     *      now()   以格林乔治正午线标准时间创建对象
     *      public static Instant ofEpochMilli(long epochMilli) 以时间戳创建
     *  -常用方法
     *      public OffsetDateTime atOffset(ZoneOffset offset) 结合即时的偏移来创建一个 OffsetDateTime
     *      public long toEpochMilli()  返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
     *
     */
    @Test
    public void test2() {
        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(1633074220974l);
        System.out.println(instant);
        System.out.println(instant1);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(instant.toEpochMilli());

    }

    /**
     * @Description LocalDate LocalTime LocalDateTime的使用
     *  -三者大同小异,LocalDate只有日期,LocalTime只有时间,LocalDateTime全有
     *  -开发中常用LocalDateTime
     *  -三者都是不可变的,类似于String
     *  -三者构造方法都是私有的
     *  -三者的时间都没有偏移量
     *
     *  构造方法
     *      static xxx now() 以当前时间创建对象
     *      static xxx of(int year,int month...)    以指定时间创建对象
     *
     *  常用操作
     *      getXXX() 获取信息 相当于Calendar的get(int field)
     *
     *      withXXX() 设置信息 相当于Calendar的set(int field,int value)
     *
     *      plusXXX() 在基础上往上加
     *      minusXXX() 在基础上往下减
     *          相当于Calendar的add(int field,int amount)
     */
    @Test
    public void test1() {
//        以当前时间创建对象
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

//        以指定时间创建对象
        LocalDateTime dateTime = LocalDateTime.of(2020, 9, 12, 14, 22, 50);
        System.out.println(dateTime);

        //getXXX() 获取信息 相当于Calendar的get(int field)
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getYear());

        //withXXX() 设置信息 相当于Calendar的set(int field,int value)
        LocalDateTime localDateTime1 = localDateTime.withYear(2022);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //plusXXX() 在基础上往上加
        //minusXXX() 在基础上往下减
        //相当于Calendar的add(int field,int amount)
        LocalDateTime localDateTime3 = localDateTime.plusHours(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime2 = localDateTime.minusDays(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

    }
}
