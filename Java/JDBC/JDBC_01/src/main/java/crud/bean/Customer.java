package crud.bean;

/**
 * @author: zhanghao
 * @date: 2021/10/22-21:00
 */

import java.sql.Date;

/**
 * @Description ORM编程思想 (Object Relational Mapping)对象映射关系
 *      在数据库中,将一个表映射为一个类
 *      一条记录映射为一条对象
 *      一个字段映射为一个属性
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private Date birth;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Customer(int id, String name, String email, Date birth) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customer() {

    }
}
