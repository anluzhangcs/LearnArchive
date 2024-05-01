package demo.ssm.service;

import demo.ssm.bean.LoginForm;
import demo.ssm.bean.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher login(LoginForm loginForm);

    List<Teacher> selectList(Teacher teacher);

    Teacher findByTno(Teacher teacher);

    int insert(Teacher teacher);

    int update(Teacher teacher);

    int deleteById(Integer[] ids);

    int updatePassowrd(Teacher teacher);

}
