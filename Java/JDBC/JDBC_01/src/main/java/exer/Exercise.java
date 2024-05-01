package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/23-20:29
 */

import crud.bean.Order;
import crud.util.JDBCUtils;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @Description
 */
public class Exercise {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            firstMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    queryMenu();
                    char q = scanner.next().charAt(0);
                    switch (q) {
                        case 'a':
                            System.out.println("请输入身份证号:");
                            String idCard = scanner.next();
                            QueryByIdCard(idCard);
                            break;
                        case 'b':
                            System.out.println("请输入准考证号:");
                            String examCard = scanner.next();
                            QueryByExamCard(examCard);
                            break;
                        default:
                            System.out.println("选项不正确,重新进入系统");
                            break;
                    }
                    break;
                case 2:
                    deleteMenu();
                    char d = scanner.next().charAt(0);
                    switch (d) {
                        case 'a':
                            System.out.println("请输入身份证号:");
                            String idCard = scanner.next();
                            deleteByIdCard(idCard);
                            break;
                        case 'b':
                            System.out.println("请输入准考证号:");
                            String examCard = scanner.next();
                            deleteByExamCard(examCard);
                            break;
                    }
                    break;
                case 3:
                    addMenu();
                    System.out.println("请输入考试类型:");
                    int type = scanner.nextInt();
                    System.out.println("请输入身份证号:");
                    String idCard = scanner.next();
                    System.out.println("请输入准考证号:");
                    String examCard = scanner.next();
                    System.out.println("请输入学生姓名:");
                    String name = scanner.next();
                    System.out.println("请输入考试地点:");
                    String location = scanner.next();
                    System.out.println("请输入考试成绩:");
                    int grade = scanner.nextInt();
                    goAdd(type,idCard,examCard,name,location,grade);
                    break;
                case 4:
                    exit(0);
                default:
                    System.out.println("您输入的选项不正确");
            }
        }
    }

    private static void QueryByIdCard(String idCard) {
        String sql = "select FlowID id,Type type,IDCard idCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";
        try {
            Student student = JDBCUtils.queryForStudent(sql, idCard);
            if (student != null) {
                System.out.println("********学生成绩*******");
                System.out.println(student);
            } else{
                System.out.println("当前系统没有此成绩信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void QueryByExamCard(String examCard) {
        String sql = "select FlowID id,Type type,IDCard idCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where ExamCard = ?";
        try {
            Student student = JDBCUtils.queryForStudent(sql, examCard);
            if (student != null) {
                System.out.println("********学生成绩*******");
                System.out.println(student);
            } else{
                System.out.println("当前系统没有此成绩信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void goAdd(Object ...args) {
        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?) ";
        try {
            JDBCUtils.update(sql,args);
            System.out.println("学生成绩添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteByIdCard(String idCard) {
        String sql = "delete from examstudent where IDCard = ?";
        try {
            JDBCUtils.update(sql,idCard);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void deleteByExamCard(String examCard) {
        String sql = "delete from examstudent where ExamCard = ?";
        try {
            JDBCUtils.update(sql,examCard);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void firstMenu() {
        System.out.println("***********四六级成绩系统***********");
        System.out.println("\t\t 1.查询成绩");
        System.out.println("\t\t 2.删除成绩");
        System.out.println("\t\t 3.添加成绩");
        System.out.println("\t\t 4.退出程序");
        System.out.println("请输入您的选择: ");
    }

    public static void queryMenu() {
        System.out.println("***************查询成绩界面************");
        System.out.println("\t\t a.准考证号");
        System.out.println("\t\t b.身份证号");
        System.out.println("请输入您的选择: ");
    }

    public static void deleteMenu() {
        System.out.println("***************删除成绩界面************");
        System.out.println("\t\t a.准考证号");
        System.out.println("\t\t a.身份证号");
        System.out.println("请输入您的选择: ");
    }

    public static void addMenu() {
        System.out.println("***************添加成绩界面************");
    }
}
