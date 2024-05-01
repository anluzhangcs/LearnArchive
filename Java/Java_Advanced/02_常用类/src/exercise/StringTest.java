package exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/26-10:17
 */

/**
 * @Description String引用传参时的易出现的陷阱
 *  -第一点要明确的是引用数据类型传参是确实是传递的地址值
 *  -String的特别之处就是他是不可变的字符串序列
 *  -在此例中形参str获取了实参的地址值,此时栈中有两个变量指向字符串常量池中的good
 *  -形参str此时要改变String的值,但他是不可变的,所以形参str指向新的常量,但真正的str没有改变
 *  -所以结果为good
 *  结论:如果String类型数据的变量str的值(地址)被赋给形参:
 *      想要通过形参改变str指向字符数组的值,不行
 *      单改变str的值,即地址值,可以.如构造函数
 */
public class StringTest {
//    private String str = new String("good");
    private String str = "good";

    private char[] ch = {'t', 'e', 's', 't'};
    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str,stringTest.ch);
        System.out.println(stringTest.ch);  //best
        stringTest.setStr("fuck");
        System.out.println("实际上的str"+stringTest.str); //good
    }
    public void change(String str1,char[] ch1){
        str1 = "bad";
        ch1[0] = 'b';
        System.out.println("形参中的str:"+str1);
    }

    public void setStr(String str) {
        this.str = str;
    }
}
