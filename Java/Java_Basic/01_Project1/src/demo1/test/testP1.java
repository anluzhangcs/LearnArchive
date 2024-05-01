package demo1.test;

import demo1.pojo.AccountInfo;
import demo1.utils.SystemFun;

import java.util.Scanner;

public class testP1 {
    public static_test void main(String[] args) {
        //创建Scanner对象 接受从控制台数输入
        Scanner scanner = new Scanner(System.in);

        SystemFun sf = new SystemFun();

        AccountInfo[] ac = new AccountInfo[100];

        int i = 0;

        double balance = 10000;

        boolean flag  = true;

        while (flag){

            sf.showHello();

            ac[i] = new AccountInfo();

            //接收int对象
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("收支" +
                        "\t\t" + "余额" + "\t\t" + "收支金额" + "\t\t" + "原因");
                    for (int j = 0; j < i; j++) {

                        System.out.println(ac[j]);
                    }
                    break;
                case 2:
                    System.out.println("请输入收入金额：");
                    double money_in = scanner.nextDouble();
                    balance += money_in;
                    System.out.println("请输入原因：");
                    String reason_in = scanner.next();
                    sf.regist_In(ac[i],reason_in,money_in,balance);
                    i++;
                    break;
                case 3:
                    System.out.println("请输入支出金额：");
                    double money_ex = scanner.nextDouble();
                    balance -= money_ex;
                    System.out.println("请输入原因：");
                    String reason_ex = scanner.next();
                    sf.regist_Ex(ac[i],reason_ex,money_ex,balance);
                    i++;
                    break;
                case 4:
                    System.out.println("是否确定退出[Y/N]：");
                    char ch = scanner.next().charAt(0);
                    if (ch=='Y'){
                        flag = false;
                        System.out.println("退出成功！");
                    } else if (ch=='N'){
                        break;
                    }
            }
        }
        System.exit(0);
    }
}
