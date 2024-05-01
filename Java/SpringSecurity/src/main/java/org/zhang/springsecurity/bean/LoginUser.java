package org.zhang.springsecurity.bean;

/**
 * @author: zhanghao
 * @date: 2022/7/22-22:40
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description 登录信息封装类
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permessions;

    @JSONField(serialize = false) //不对其序列化存到redis中
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(User user, List<String> permessions) {
        this.user = user;
        this.permessions = permessions;
    }


    //返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //从loginUser成员变量中获取权限信息并封装为Collection<? extends GrantedAuthority>
        if (!Objects.isNull(authorities)) {
            return authorities;
        }
        //string流写法
        authorities = permessions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
