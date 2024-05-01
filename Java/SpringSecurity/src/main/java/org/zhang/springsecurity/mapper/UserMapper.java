package org.zhang.springsecurity.mapper;

/**
 * @author: zhanghao
 * @date: 2022/7/18-9:44
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zhang.springsecurity.bean.User;

/**
 * @Description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
