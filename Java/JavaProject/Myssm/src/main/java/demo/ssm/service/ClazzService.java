package demo.ssm.service;

import demo.ssm.bean.Clazz;

import java.util.List;

public interface ClazzService {

    List<Clazz> selectList(Clazz clazz);

    List<Clazz> selectAll();

    int insert(Clazz clazz);

    int deleteById(Integer[] ids);

    Clazz findByName(String name);

    int update(Clazz clazz);

}
