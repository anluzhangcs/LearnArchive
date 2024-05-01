package demo.ssm.dao;

import demo.ssm.bean.LoginForm;
import demo.ssm.bean.Student;

import java.util.List;

public interface StudentMapper {

    Student login(LoginForm loginForm);

    List<Student> selectList(Student student);

    Student findBySno(Student student);

    int insert(Student student);

    int update(Student student);

    int updatePassword(Student student);

    int deleteById(Integer[] ids);

}
