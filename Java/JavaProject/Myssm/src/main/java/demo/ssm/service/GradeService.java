package demo.ssm.service;

import demo.ssm.bean.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> selectList(Grade gradename);

    List<Grade> selectAll();

    Grade findByName(String gradename);

    int insert(Grade grade);

    int update(Grade grade);

    int deleteById(Integer[] ids);
}
