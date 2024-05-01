package view;

/**
 * @author: zhanghao
 * @date: 2021/9/19-18:56
 */

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import service.NameListService;
import service.TeamService;

import java.util.Scanner;

/**
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        NameListService ns = new NameListService();
        ns.init();
        TeamService tm = new TeamService(ns);
        tm.init();
        ns.show();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int menu = scanner.nextInt();

        while (flag){

            switch (menu){
                case 1:
                    tm.show();
                    break;
                case 2:
                    System.out.println("---------------------添加成员-----------------------");
                    System.out.println("请输入要添加员工ID:");
                    int id = scanner.nextInt();
                    tm.addMember(id);
                     break;
                case 3:
                    System.out.println("---------------------删除成员-----------------------");
                    System.out.println("请输入要删除员工TID:");
                    int tid = scanner.nextInt();
                    tm.deleteMember(tid);
                    break;
                case 4:
                    System.exit(0);
            }
            menu = scanner.nextInt();
        }
    }
}
