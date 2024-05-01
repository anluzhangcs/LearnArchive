package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/19-11:24
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description try-catch-finally
 *      try{
 *          //可能出错的代码
 *      }catch(xxxException e){
 *          //一旦try中出现异常,catch会捕获对应的异常,并执行catch中的代码
 *
 *          //常用方法
 *          e.printStackTrace(); //打印错误信息
 *          e.getMessage();      //获取错误信息
 *      }catch(xxxException e){
 *          注意点:
 *          ① catch语句可以有多个,捕获不同的异常,但范围大的异常要放在后面,负责范围小的异常进不去会报错
 *
 *      }...finally{
 *          //可选
 *          //一定会执行的代码,不管try中是否发生异常,try中是否有return,catch中是否有return
 *          通常将输入输出流,数据库连接等JVM无法回收的数据进行手动关闭
 *      }
 *  总结:try-catch-finally会将编译时异常延时到运行时,而对运行时异常则没必要进行处理,因为出现异常我们
 *       本来就是要改代码的,打印错误信息没必要.
 */
public class tryException {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            //hello.txt是相对路径,在项目的根目录下
            File file = new File("hello1.txt");
            fileInputStream = new FileInputStream(file);
            int data= fileInputStream.read();
            while (data != -1){
                System.out.print((char)data);
                data = fileInputStream.read();
            }
            return ;

        }catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
         finally {
            System.out.println("我一定会被执行!");
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
