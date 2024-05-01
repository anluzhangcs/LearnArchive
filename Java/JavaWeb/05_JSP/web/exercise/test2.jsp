<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>输出表格,里面有十个学生信息</h1>

    <%!
        //定义存储Student对象的List
        List<Student> students = new ArrayList<>();
        //定义Student类
        class Student{
            private String username;
            private String sex;
            private int age;

            public Student(String username, String sex, int age) {
                this.username = username;
                this.sex = sex;
                this.age = age;
            }

            public Student() {

            }

            public String getName() {
                return username;
            }

            public void setName(String username) {
                this.username = username;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
    %>
    <%
        //存储数据
        students.add(new Student("张三", "男", 21));
        students.add(new Student("李四", "男", 20));
        students.add(new Student("小红", "女", 22));
        students.add(new Student("张三", "男", 21));
        students.add(new Student("张三", "女", 19));
        students.add(new Student("张三", "男", 21));
        students.add(new Student("张三", "男", 21));
        students.add(new Student("张三", "女", 18));
        students.add(new Student("张三", "男", 21));
        students.add(new Student("张三", "男", 23));
    %>

    <%--显示数据--%>
    <table>
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
        </tr>
        <%
            for (int i = 0; i < 10; i++) {
        %>
        <tr>
            <td><%=students.get(i).getName()%></td>
            <td><%=students.get(i).getSex()%></td>
            <td><%=students.get(i).getAge()%></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>
