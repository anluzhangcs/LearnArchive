package innerClass;

/**
 * @author: zhanghao
 * @date: 2021/10/8-14:06
 */

/**
 * @Description 内部类:在类内部的类,一般为private,给外部类使用
 *  |---成员内部类 (常用)
 *      |---非静态内部类
 *          -非静态内部类属于外部类的对象,没有外部类对象,就没有内部类
 *          -内部类对象中存放着创建它的外部类对象的引用,这就是他能调用外部类方法和属性的原因
 *          -内部类可以访问外部类的所有属性,方法,构造器.
 *          -外部类若想访问内部类中成员,则必须先创建内部类对象.
 *          -内部类中不能有静态方法或属性
 *  内部类的创建
 *      ①在外部类作为成员变量被创建
 *      InnerClass inner = new InnerClass()
 *      ②在外部类的main方法中被创建
 *      OuterClass outer = new OuterClass();
 *      InnerClass inner = outer.new InnerClass();
 *      ③在其它类中被创建
 *      OuterClass outer = new OuterClass();
 *      OuterClass.InnerClass inner = outer.new InnerClass();
 *
 *      |---静态内部类
 *          -静态内部类属于外部类本身而不是外部类对象
 *          -静态内部类不能访问外部类的非静态方法或属性
 *          -外部类可以通过静态内部类访问内部类的类成员,或通过对象访问实例成员
 *
 *  静态内部类的创建
 *      ①在外部类作为成员变量被创建
 *      InnerClass inner = new InnerClass()
 *      ②在外部类的main方法中被创建
 *      OuterClass.InnerClass inner = new InnerClass();
 *      ③在其它类中被创建
 *      OuterClass.InnerClass inner = new OuterClass.InnerClass();
 *
 *  |---局部内部类 :如方法,代码块,构造器.此中的内部类一般是匿名类,作为临时使用
 */
public class OuterClass {
    private int i;
    private static String name;
    public OuterClass(int i) {
        this.i = i;
    }
//    Inner inner = new Inner();
InnerClass2 innerClass2 = new InnerClass2();
    public void show() {
        System.out.println("normal method is called!!!");
//        inner.m1();
    }

    static void cry() {
//        Inner inner = new Inner();
        System.out.println("static method is called");
InnerClass2.m2();
    }


    class InnerClass{
        private int i=2;
        public void m1() {
            int i =3 ;
            System.out.println(i);
            System.out.println(this.i);
            System.out.println(OuterClass.this.i);
            OuterClass.name = "BB";
            cry();
            show();
        }
//        public static void m2() {
//
//        }
//        static int age;
    }

    static class InnerClass2{
        private int i =2;

        public void m1() {
            cry();
            name="AA";
        }

        static void m2() {
            cry();
        }
    }

    public static void main(String[] args) {
        OuterClass o = new OuterClass(1);
        InnerClass inner = o.new InnerClass();
        inner.m1();

        OuterClass.InnerClass2 inner2 = new InnerClass2();
    }
}
