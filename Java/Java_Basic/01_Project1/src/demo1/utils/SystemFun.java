package demo1.utils;

import demo1.pojo.AccountInfo;


public class SystemFun {
    public void showHello(){
        java.lang.System.out.println("===============家庭收支记账软件=================");
        java.lang.System.out.println("\t1 收支明细");
        java.lang.System.out.println("\t2 登记收入");
        java.lang.System.out.println("\t3 登记支出");
        java.lang.System.out.println("\t4 退出");
        java.lang.System.out.println("\t请选择(1-4):");
    }

    public void regist_In(AccountInfo accountInfo,String reason,double money,double balance){
        accountInfo.setReason(reason);
        accountInfo.setIn_ex("收入");
        accountInfo.setMoney(money);
        accountInfo.setBalance(balance);
    }
    
    public void regist_Ex(AccountInfo accountInfo,String reason,double money,double balance){
        accountInfo.setReason(reason);
        accountInfo.setIn_ex("支出");
        accountInfo.setMoney(money);
        accountInfo.setBalance(balance);
    }
}
