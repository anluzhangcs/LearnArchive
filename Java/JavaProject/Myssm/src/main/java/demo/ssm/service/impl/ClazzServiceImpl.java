package demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.ssm.bean.Clazz;
import demo.ssm.dao.ClazzMapper;
import demo.ssm.service.ClazzService;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    //注入Mapper接口对象
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> selectList(Clazz clazz) { return clazzMapper.selectList(clazz); }

    @Override
    public List<Clazz> selectAll() {
        return clazzMapper.selectAll();
    }

    @Override
    public Clazz findByName(String name) {
        return clazzMapper.findByName(name);
    }

    @Override
    public int insert(Clazz clazz) {
        return clazzMapper.insert(clazz);
    }

    @Override
    public int update(Clazz clazz) {
        return clazzMapper.update(clazz);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return clazzMapper.deleteById(ids);
    }
}
