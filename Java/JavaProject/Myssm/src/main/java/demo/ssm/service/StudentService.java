package demo.ssm.service;

import demo.ssm.bean.LoginForm;
import demo.ssm.bean.Student;

import java.util.List;


public interface StudentService {


    Student login(LoginForm loginForm);

    List<Student> selectList(Student student);

    Student fingBySno(Student student);

    int insert(Student student);

    int update(Student student);

    int updatePassowrd(Student student);

    int deleteById(Integer[] ids);

}

