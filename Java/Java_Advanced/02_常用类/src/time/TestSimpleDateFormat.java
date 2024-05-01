package time;

/**
 * @author: zhanghao
 * @date: 2021/10/1-9:10
 */

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description SimpleDateFormat
 *      -格式化日期,用于Date和String之间的格式化转换
 *      -一般不用默认构造器,而使用指定构造器,比较灵活
 *      -pattern和source格式一定要对应,否则会抛出异常
 */
public class TestSimpleDateFormat {

    /*
     * @Description  三天打鱼两天晒网 判断某一天是在打鱼还是在晒网
     * @param
     * @return  void
     */
    @Test
    public void test3() throws ParseException {
        Date start = new Date();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String s = scanner.next();
        Date now = sdf.parse(s);
        System.out.println(now);

        //方式一
//        int cnt = (int) ((now.getTime() - start.getTime()) / (1000 * 24 * 60 * 60) +1);

        int cnt = now.getDay()-start.getDay();

        switch (cnt) {
            case 1: case 2: case 3:
                System.out.println("在打鱼");
            case 0: case 4:
                System.out.println("在筛网");
        }
    }

    /*
     * @Description  String 转化为 java.sql.Date
     *      -利用SimpleDateFormat的parse()转换为java.util.Date
     *      -然后利用Date.getTime()获取时间戳构造java.sql.Date对象
     * @param
     * @return  void
     */
    @Test
    public void test2() throws ParseException {
        String str = "2021-10-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(str);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);

    }


    @Test
    public void test1() throws ParseException {
        //默认构造器生成 pattern:21-10-1 上午9:22
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println("*************当前时间**********");
        System.out.println(date);

        //1.解析 format(Date date)
        String format = sdf.format(date);
        System.out.println("*************默认格式化************");
        System.out.println(format);

        //2.将字符串格式化为Date parse(String source)
        String str = "21-10-2 上午9:22";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //指定格式(pattern)format和parse 2021-10-01 星期五 09:30:40
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd EEE hh:mm:ss");
        System.out.println("*************指定格式化************");
        String format1 = sdf2.format(date);
        System.out.println(format1);

        String str1 = "2021-10-02 星期五 09:30:40";
        Date date2 = sdf2.parse(str1);
        System.out.println(date2);

    }
}
