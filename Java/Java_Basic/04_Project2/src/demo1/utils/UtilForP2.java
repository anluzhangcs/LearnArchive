package demo1.utils;

/**
 * @author: zhanghao
 * @date: 2021/9/11-11:57
 */

import demo1.java.Customer;

import java.util.Scanner;

/**
 * @Description
 */
public class UtilForP2 {
    Scanner scanner = new Scanner(System.in);
    Customer[] customers = new Customer[10];
    int num=0;
    public int  start(){
        System.out.println("==========================客户信息管理界面===================");
        System.out.println("\t1：添加客户");
        System.out.println("\t2：修改客户");
        System.out.println("\t3：删除客户");
        System.out.println("\t4：客户列表");
        System.out.println("\t5：退出");
        System.out.println("请选择1-5：");
        return scanner.nextInt();
    }

    public void addCustomer(){
        customers[num] = new Customer();
        System.out.print("请输入姓名：");
        customers[num].setName(scanner.next());
        System.out.print("请输入性别：");
        customers[num].setSex(scanner.next());
        System.out.print("请输入电话：");
        customers[num].setPhone(scanner.next());
        System.out.print("请输入邮箱：");
        customers[num].setEamil(scanner.next());
        customers[num].setId(num+1);
        num++;
        System.out.println("=========添加完成===========");
    }

    public void updateCustomer(){
        System.out.print("请输入要修改的客户id：");
        int index = scanner.nextInt();
        if (index<=0){
            return ;
        }
        scanner.nextLine();
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
        if (name.indexOf(0)!=13)
        customers[index-1].setName(name);
        System.out.print("请输入性别：");
        String sex = scanner.nextLine();
        if (name.indexOf(0)!=13)
        customers[index-1].setSex(sex);
        System.out.print("请输入电话：");
        String phone = scanner.nextLine();
        if (name.indexOf(0)!=13)
        customers[index-1].setPhone(phone);
        System.out.print("请输入邮箱：");
        String email = scanner.nextLine();
        if (name.indexOf(0)!=13)
        customers[index-1].setEamil(email);
        System.out.println("=========修改完成===========");
    }

    public void deleteCustomer(){
        System.out.print("请输入要删除的客户id：");
        int index = scanner.nextInt();
        if (index<=0){
            return ;
        }
        for (int i = index-1 ; i < num-1; i++) {
            customers[i] = customers[i+1];
            customers[i].setId(i+1);
        }
        num--;
        System.out.println("=========删除完成===========");
    }

    public void showCustomer(){

        System.out.println("Id\t\t姓名\t\t性别\t\t电话\t\t邮箱");

        for (int i = 0; i < num; i++) {
            System.out.println(customers[i]);
        }
    }

    public void showCustomer(int id){
        System.out.println("Id\t\t姓名\t\t性别\t\t电话\t\t邮箱");
        System.out.println(customers[id-1]);
    }

}
