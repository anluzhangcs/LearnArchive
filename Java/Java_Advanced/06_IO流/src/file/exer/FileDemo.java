package file.exer;

/**
 * @author: zhanghao
 * @date: 2021/10/10-16:54
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Description File类的简单测试
 */
public class FileDemo {

    //1. 利用File构造器，new 一个文件目录file
    //1)在其中创建多个文件和目录
    //2)编写方法，实现删除file中指定文件的操作
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\Fuck"); //内存层面
//        boolean mkdir = file.mkdir(); //硬盘层面
//
//        String first = file.getAbsolutePath();
//        file = new File(first + "\\apple.txt");
//        file.createNewFile();
//
//        file = new File(first + "\\pear.txt");
//        file.createNewFile();
//
//        file = new File(first, "suck");
//        file.mkdir();
//
//
//        file = new File(file.getAbsolutePath() + "\\penus.txt");
//        file.createNewFile();
//        file = new File(file.getParent(), "\\titty.txt");
//        file.createNewFile();

//        file = new File("D:\\Fuck");
//        System.out.println(getSize(file));

//        findJpg(file);
        deleteAll(file);
    }


    //2判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    public void findJpg(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (int i = 0;i<files.length;i++){
               findJpg(files[i]);
            }
        } else{
            String name = file.getName();

            if (name.endsWith(".jpg")) {
                System.out.println(name);
            }
            else{
                System.out.println(file.getName()+"不是jpg文件");
            }
        }
    }

    //3遍历指定目录所有文件名称，包括子文件目录中的文件。
    //拓展1：并计算指定目录占用空间的大小
    //拓展2：删除指定文件目录及其下的所有文件

    public void show(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    show(files[i]);
                } else{
                    System.out.println(files[i]);
                }
            }
        } else {
            System.out.println("这是一个文件不是目录");
            System.out.println(file);
        }
    }
    int sum =0;
    public int getSize(File file) {

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
//                if (files[i].isDirectory()) {
//                    getSize(files[i]);
//                } else{
//                    sum+=files[i].length();
//                }
                getSize(files[i]);
            }
        } else{
            sum+=file.length();
        }
        return sum;
    }

    public void deleteAll(File file){
        File[] files = file.listFiles();
        if (files == null) {
            file.delete();
        } else{
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteAll(files[i]);
                } else{
                    files[i].delete();
                }
            }
            file.delete();

        }
    }
}
