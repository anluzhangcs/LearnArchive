package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/10-22:30
 */

/**
 * @Description
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{\n" +
                "姓名：" + firstName + ' ' +
                 lastName + '\n' +
                "账户信息：" + account +
                '}';
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }
}
