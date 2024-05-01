package file;

/**
 * @author: zhanghao
 * @date: 2021/10/10-12:31
 */


import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Description File类的使用
 *  -java.io.File
 *  -File类对象可以是文件也可以是目录
 *  -File对象是Java内存中对应真实磁盘文件
 *  -File对象实例化时只是在内存中创建类File对象,至于实际path存不存在,暂时不重要
 *  -File类的方法对文件或目录进行创建,删除,重命名,判断操作...但没有对磁盘上的文件进行读写
 *  -IO流来进行文件的读写,而File对象一般放到IO流的构造器中
 */
public class FileTest {

    /*
     * @Description  File类的实例化
     *  1.File(String pathname)
     *  2.File(String parent,String child)
     *  3.File(File parent,String child)
     *  注:sout(File)输出的是path
     *  知识补充:路径问题
     *      相对路径:在idea中相对于module根目录
     *      绝对路径:盘符路径
     *      路径分隔符:
     *          -Windows使用\,但Java中避免转义字符使用\\
     *          -Unix系统,URL使用/
     *          -为了Java的跨平台性,File中有一个separator常量用作分隔符
     */
    @Test
    public void test1() {
        //public File(String pathname)
        File file1 = new File("hello.txt");
        File file11 = new File("D:\\Code\\Java\\Java_Advanced\\IO流");
        File file111 = new File("D:"+File.separator+"Code");
        System.out.println(file1);
        System.out.println(file11);// D:\Code\Java\Java_Advanced\IO流
        System.out.println(file111); //D:\Code

        //public File(String parent, String child)
        File file2 = new File("D:\\Code\\Java\\Java_Advanced","IO流");
        System.out.println(file2);// D:\Code\Java\Java_Advanced\IO流

        //public File(File parent, String child)
        File file3 = new File(file2, "he.txt");
        System.out.println(file3);// D:\Code\Java\Java_Advanced\IO流\he.txt

    }

    /*
     * @Description  File类常用方法
     *  public String getAbsolutePath() 获取绝对路径
     *  public String getPath()         获取实例化时构造器中的path
     *  public String getName()         获取文件或目录名
     *  public String getParent()       获取上一级目录
     *  public long length()            获取文件字节数
     *  public long lastModified()      获取文件最后修改时间
     */
    @Test
    public void test2() {

        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        //若使用相对路径创建File对象,则上一级目录为null
        System.out.println(file1.getParent()); //null
        System.out.println(file1.getName());
        //注:length()方法获取字节数,而不是字符数.
        System.out.println(file1.length()); //11=5+6=5个英语2个汉字
        System.out.println(file1.lastModified());

        System.out.println("*************");

        File file2 = new File("D:\\Code\\Java\\Java_Advanced\\hi.txt");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getParent());
        System.out.println(file2.getName());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    //以下两个方法是适用于目录的
    //public String[] list() 获取目录下所有文件和子目录的命名
    //public File[] listFiles() 获取目录下所有文件和子目录
    //注:在使用上述两个方法时,目录不能为空,否则会抛出NullPointerException
    @Test
    public void test3() {
        File file1 = new File("D:\\AllDownload");

        String[] list = file1.list(); //null
        for (String s : list) { //NullPointerException
            System.out.println(s);
        }

        File[] files = file1.listFiles();
        for (File f : files) { //NullPointerException
            System.out.println(f);
        }
    }

    @Test
    //public boolean renameTo(File dest) 重命名
    //f1.renameTo(f2) 将f1移动到f2所在路径,并改名为f2
    //注:只有f1真实存在,f2不存在,才会成功,返回true
    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Code\\Java\\Java_Advanced\\hi.txt");

//        file2 = null;  //dest不能为null,负责抛出NullPointerException

        System.out.println(file1.renameTo(file2));
    }

    @Test
    //文件或目录的判断方法
    //public boolean isFile()        判断是否是文件
    //public boolean isDirectory()   判断是否是目录
    //public boolean exist()        判断是否存在
    //public boolean canRead()   判断是否可读
    //public boolean canWrite()   判断是否可写
    //public boolean canExecute()   判断是否可执行,并不是指是否是.exe文件
    //public boolean isHidden()   判断是否隐藏
    public void test5() {
        File file1 = new File("hello.txt");
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println(file1.canExecute());

        System.out.println("***************");

        File file2 = new File("d:\\All Download");
        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
        System.out.println(file2.canExecute());
    }

    @Test
    //文件或目录的创建,删除
    //public boolean createNewFile() throws IOException 创建新文件
    //public boolean mkdir()    创建一级目录
    //public boolean mkdirs()   递归创建多级目录
    //public boolean delete()   删除文件或目录,
    public void test6() throws IOException {
//        File file1 = new File("hi.txt");
//        //判断文件是否存在,存在返回false,创建失败
//        System.out.println(file1.createNewFile());
//        System.out.println(file1.delete());

        File file2 = new File("D:\\Fuck\\suck");
//        System.out.println(file2.mkdir());
//        System.out.println(file2.mkdirs());
        System.out.println(file2.delete());
    }

    @Test
    public void ew() {
        String str = "hello.txt";
        String[] split = str.split(".");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

}
