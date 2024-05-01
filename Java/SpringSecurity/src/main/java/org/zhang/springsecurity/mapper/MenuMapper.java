package org.zhang.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zhang.springsecurity.bean.Menu;

import java.util.List;

/**
 * @author: Zhanghao
 * @date: 2022/7/26-15:27
 * @Description TODO
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userId);

}
