package demo.ssm.dao;

import demo.ssm.bean.Clazz;

import java.util.List;

public interface ClazzMapper {

    List<Clazz> selectList(Clazz clazz);

    List<Clazz> selectAll();

    Clazz findByName(String name);

    int insert(Clazz clazz);

    int deleteById(Integer[] ids);

    int update(Clazz clazz);

}
