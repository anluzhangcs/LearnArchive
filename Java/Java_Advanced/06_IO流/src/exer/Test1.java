package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/11-20:53
 */

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description 小练习
 */
public class Test1 {

    @Test
//    获取文本上每个字符出现的次数
    public void test1() {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("art.txt"));
            HashMap<Character, Integer> map = new HashMap<>();

            char[] cbuf = new char[10];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    if (spliter(cbuf[i]) == 1) {
                        if (map.containsKey(cbuf[i])) {
                            Integer cnt = map.get(cbuf[i]);
                            map.put(cbuf[i], cnt + 1);
                        } else{
                            map.put(cbuf[i], 1);
                        }
                    }
                }
            }

            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fr != null) {

                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int spliter(char ch) {
        switch (ch) {
            case ',': case '.': case ' ': case '\'': case '\n':
            case '\r': case '\t':
                return 0;
            default:
                return 1;
        }
    }

    @Test
    //对图片进行加密操作
    public void test2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("wangfei.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("wangfei_s.jpg")));

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5); //异或操作进行加密
                }
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    //解密操作 <==>加密的逆过程
    public void test3() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("wangfei_s.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("wangfei2.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i]^5); //异或操作进行加密
                }
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
