package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/23-20:29
 */

/**
 * @Description
 */
public class Student {
    private int id;
    private int type;
    private String idCard;
    private String examCard;
    private String name;
    private String location;
    private int grade;

    @Override
    public String toString() {
        return
                "流水号:" + id +
                "\n考试类型:" + type +
                "\n身份证号:" + idCard +
                "\n准考证号:" + examCard +
                "\n姓名:" + name +
                "\n位置:" + location +
                "\n成绩:" + grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(int id, int type, String idCard, String examCard, String name, String location, int grade) {
        this.id = id;
        this.type = type;
        this.idCard = idCard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    public Student() {

    }
}
