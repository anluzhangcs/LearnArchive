package demo1.java.Method;

/**
 * @author: zhanghao
 * @date: 2021/9/10-14:02
 */

/**
 * @Description 可变个数的形参
 * 要点：
 *      1.格式为 类型 ... 变量名
 *      2.可以与类中同方法名，参数列表不同的方法构成重载
 *      3.如果有其它参数，可变个数形参必须放在列表末尾（避免编译时混淆）
 *      4.本质上相当于是数组当形参，所以参数也具备数组的特性。二者只能选一个，否则会冲突
 *      5.可变形参个数可以为0
 */
public class MethodArgs {

    public void show(String str){
        System.out.println("show String str:"+str);
    }

    public void show(String ... strs){
        System.out.println("show String strs:");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    public void show(int i,String ... strs){}

//    public void show(String[] strs){
//
//    }
}
