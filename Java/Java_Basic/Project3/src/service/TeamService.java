package service;

/**
 * @author: zhanghao
 * @date: 2021/9/19-17:24
 */

import domain.Employee;

/**
 * @Description
 */
public class TeamService {
    NameListService ns ;

    public TeamService(NameListService ns) {
        this.ns = ns;
    }

    Employee[] team = new Employee[6];
    public void init(){
        team[0] = ns.getEmployees()[3];
        team[0].setTid(1);
//        team[1] =ns.getEmployees()[9];
//        team[1].setTid(2);
//        team[2] = ns.getEmployees()[2];
//        team[2].setTid(3);
//        team[3] = ns.getEmployees()[5];
//        team[3].setTid(4);
    }

    public void show(){
        System.out.println("----------------------团队列表-------------------------");
        System.out.println("TDI/ID     姓名         年龄      工资       职位      奖金        股票");
        int i = 0;
        while (team[i]!=null){
            System.out.println(team[i].teamShow());
            i++;
        }
    }

    public void addMember(int id){
        int index=0;
        while (team[index]!=null){
            index++;
            if (index == team.length){
                break;
            }
        }

        team[index] = ns.getEmployees()[id];
        team[index].setTid(index+1);
    }

    public void deleteMember(int tid){
        if (team[tid] == null){
            team[tid-1] =null;
        }else{
            int i = tid-1;
            while (team[i]!=null){
                team[i] = team[i+1];
                team[i].setTid(i+1);
                i++;
            }
            team[i-1] = null;
        }
    }
}
