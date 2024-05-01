package main_test;

/**
 * @author: zhanghao
 * @date: 2021/9/13-11:19
 */

/**
 * @Description
 */
public class Dog {

    public Dog(){
        System.out.println("现在我被创建了");
    }
    public void eat(){
        System.out.println("吃骨头");
    }
    
    /*
     * @Description  类中的方法可以创建它本身
     * 类和类中的方法属性只是声明，在没有创建对象之前并调用之前是并不会执行的
     * 而类创建完后，代表类已经加载到方法区中了，此时调用方法就可以创建对象
     *
     * @param
     * @return  void
     */
    public void cry(){
        Dog dog = new Dog();
        dog.eat();
    }

    public static void main(String[] args) {
        System.out.println("dog的main方法被调用");
    }
}
