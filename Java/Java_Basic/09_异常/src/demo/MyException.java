package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/19-15:38
 */

/**
 * @Description 自定义异常
 *      -需要继承现有的异常
 *      -一般有一个序列化常量,无参构造方法,有参的构造方法
 */
public class MyException extends RuntimeException {
    static final long serialVersionUID = -3387516993124229948L;

    public MyException(){

    }
    public MyException(String msg){
        super(msg);
    }
}
