package block;

/**
 * @author: zhanghao
 * @date: 2021/9/14-13:02
 */

/**
 * @Description 代码块的测试
 */
public class BlockTest {
    public static void main(String[] args) {
        String str = Person.getDesc();
        System.out.println(str);
        Person person = new Person();
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}
