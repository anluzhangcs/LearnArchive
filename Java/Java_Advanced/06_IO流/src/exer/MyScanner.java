package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/12-13:23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description 自己创建一个类实现Scanner类的一些操作,如next(),nextInt()...
 */
public class MyScanner {
    private InputStream in;
    public MyScanner(InputStream in) {
        this.in = in;
    }

    private static BufferedReader br =null;
    public String next() {
        br = new BufferedReader(new InputStreamReader(in));

        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Integer nextInt() {
        String s = next();

        return Integer.parseInt(s);
    }

    public Double nextDouble(){
        String s = next();
        return Double.parseDouble(s);
    }

    public void close() {
        if (br!=null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
