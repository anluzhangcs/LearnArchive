package wapper_test;

/**
 * @author: zhanghao
 * @date: 2021/9/12-16:52
 */

import java.util.Scanner;
import java.util.Vector;

/**
 * @Description
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
 * 最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
 * 长度。而向量类java.util.Vector可以根据需要动态伸缩。
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj); //obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等；20分内：B等；
 * 30分内：C等；其它：D等
 */
public class Exercise1 {
    public static void main(String[] args) {
        Vector vector = new Vector();
        Scanner scanner = new Scanner(System.in);
        double score  = scanner.nextDouble();
        double maxScore = 0;
        while (score>=0){
            vector.addElement(score);
            if (score>maxScore){
                maxScore = score;
            }
            score = scanner.nextDouble();
        }

        for (int i = 0; i < vector.size(); i++) {
            if (maxScore-(Double) vector.elementAt(i)<=10){
                System.out.println((Double) vector.elementAt(i)+"is A");
            } else if (maxScore-(Double) vector.elementAt(i)<=20){
                System.out.println((Double) vector.elementAt(i)+"is B");
            } else if (maxScore-(Double) vector.elementAt(i)<=30){
                System.out.println((Double) vector.elementAt(i)+"is C");
            } else{
                System.out.println((Double) vector.elementAt(i)+"is D");
            }
        }
    }
}
