package demo1.pojo;


public class AccountInfo {
    private double balance;
    private String in_ex;
    private double money;
    private String reason;
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIn_ex() {
        return in_ex;
    }

    public void setIn_ex(String in_ex) {
        this.in_ex = in_ex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return in_ex +
                "\t" + balance + "\t\t" + money + "\t\t" + reason;
    }
}


