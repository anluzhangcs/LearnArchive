package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/11-11:54
 */

/**
 * @Description
 */
public class Customer {
    private int id;
    private String name;
    private String sex;
    private String phone;
    private String eamil;

    @Override
    public String toString() {
        return
                id +
                "\t\t" + name +
                        "\t\t" + sex +
                        "\t\t" + phone +
                        "\t\t" + eamil ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
}
