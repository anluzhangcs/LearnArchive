package demo.ssm.service;

import demo.ssm.bean.Admin;
import demo.ssm.bean.LoginForm;

import java.util.List;

public interface AdminService {

    Admin login(LoginForm loginForm);

    Admin findByName(String name);

    int insert(Admin admin);

    List<Admin> selectList(Admin admin);

    int update(Admin admin);

    int updatePassowrd(Admin admin);

    int deleteById(Integer[] ids);

}