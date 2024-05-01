package domain;

/**
 * @author: zhanghao
 * @date: 2021/9/19-17:14
 */

/**
 * @Description
 */
public abstract class Employee {
    private int id;
    private int tid;
    private String name;
    private int age;
    private double salary;
    private String position;
    private String status;
    private double reward;
    private int stock;
    private Equipment equipment;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Employee(){

    }

    public Employee(int id, String name, int age, double salary, String position, double reward, int stock, Equipment equipment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.status = "free";
        this.reward = reward;
        this.stock = stock;
        this.equipment = equipment;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return
                id +
                "\t\t" + name +
                "\t" + age +
                "\t\t" + salary +
                "\t" + position +
                "\t" + status +
                "\t" + reward +
                "\t\t" + stock +
                "\t" + equipment ;
    }

    public String teamShow(){
        return tid+"/"+id+"\t\t"+name+"\t\t"+age+'\t'+salary+"\t\t"+position+"\t\t"+reward+'\t'+stock;
    }
}
