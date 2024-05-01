package demo.ssm.dao;

import demo.ssm.bean.Admin;
import demo.ssm.bean.LoginForm;

import java.util.List;

public interface AdminMapper {

    Admin login(LoginForm loginForm);


    Admin findByName(String name);


    int insert(Admin admin);


    List<Admin> selectList(Admin admin);

    int update(Admin admin);

    int updatePassword(Admin admin);

    int deleteById(Integer[] ids);

}