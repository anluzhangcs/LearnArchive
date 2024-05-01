package org.zhang.mybatis.bean;

/**
 * @author: zhanghao
 * @date: 2022/1/28-18:20
 */

import org.apache.ibatis.type.Alias;

/**
 * @Description
 */

public class User {
    private Integer id;

    private String username;

    private String pwd;

    public User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.pwd = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPwd(String password) {
        this.pwd = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + pwd + '\'' +
                '}';
    }
}
