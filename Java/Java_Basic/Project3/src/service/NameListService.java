package service;

/**
 * @author: zhanghao
 * @date: 2021/9/19-17:24
 */

import domain.*;

/**
 * @Description
 */
public class NameListService {
    private Employee[] employees = new Employee[10];

    public Employee[] getEmployees() {
        return employees;
    }

    public void init(){
        employees[0] = new Programer(1,"mayun",22,3000,new Laptop("联想","xiaoxin-air14"));
        employees[1] = new Programer(2,"leijun",22,3000,new Laptop("联想","xiaoxin-pro14"));
        employees[2] = new Programer(3,"qiaobusi",22,3000,new Laptop("huipu","anyingjinlin"));
        employees[3] = new Programer(4,"zhangsan",22,3000,new Laptop("apple","macbook"));
        employees[4] = new Designer(5,"mahuateng",22,3000,new PC("联想","Thinkpad10"));
        employees[5] = new Designer(6,"huaqiang",22,3000,new PC("huipu","Thinkpad10"));
        employees[6] = new Designer(7,"lisi",22,3000,new PC("shengzhou","Thinkpad10"));
        employees[7] = new Architect(8,"wangwu",22,3000,new Camera("jianeng","T210"));
        employees[8] = new Architect(9,"wangmazi",22,3000,new Camera("jianeng","T210"));
        employees[9] = new Architect(10,"wangjianlin",22,3000,new Camera("jianeng","T210"));
    }

    public void show(){
        System.out.println("--------------------------开发团队调度软件-------------------------");
        System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        int i = 0;
        while (employees[i]!=null){
            System.out.println(employees[i]);
            i++;
            if (i == 10){
                break;
            }
        }
        System.out.println("......");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
    }



}
