package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/19-14:18
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description throws
 *      -只是单纯的将异常抛出,并没有进行处理,而try-catch-finally真正对其处理了
 *      -throws将异常抛出到上一层,即调用此方法的调用者
 *      -随着throws层级向上抛,直到main方法,throws的异常范围也要递增,否则匹配不到也会报错
 *      -编译时异常最后还是要被try-catch-finally处理
 */
public class throwsException {
    public static void main(String[] args) {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws Exception{
        method1();
    }

    public static void method1() throws IOException {
        File file = new File("hello1.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1){
            System.out.print((char)data);
            data = fis.read();
        }
        fis.close();
    }
}
