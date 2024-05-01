package java8;

/**
 * @author: zhanghao
 * @date: 2021/9/17-20:48
 */

/**
 * @Description
 *  当实现的多个接口中有相同方法时，实现类必须重写方法  -------接口冲突
 *  当上述情况中实现类父类中有相同方法时，则调用父类方法 ------类优先原则
 */
public class Myself extends Father implements Filial,Spoony {
    @Override
    public void help() {
        System.out.println("我该怎么办？");
        //接口调用静态方法
        Filial.destiny();

        //接口调用默认方法
        Filial.super.help();
        Spoony.super.help();
    }
}
