package dao;

/**
 * @author: zhanghao
 * @date: 2021/10/30-22:13
 */

import bean.User;

/**
 * @Description UserDao的接口,定义了需要的CRUD操作==>完成登陆注册操作
 */
public interface UserDao {

    /*
     * @Description  查找用户名是否存在
     * @param username
     * @return  bean.User.若存在,则用户名不可用;若返回null,则用户名可用
     */
    User queryByName(String username);

    /*
     * @Description  查找该邮箱是否绑定了用户
     * @param email
     * @return  bean.User.若不为null,该邮箱已绑定用户,登录或者换其他邮箱;反之正常
     */
    User queryByEmail(String email);

    /*
     * @Description  添加用户记录
     * @param user
     * @return  void
     */
    void addUser(User user);

    /*
     * @Description  查找该用户名和密码是否有用户
     * @param username
     * @param password
     * @return  bean.User.若不为null,则该用户存在;反之该用户不存在,需要注册
     */
    User queryForLogin(String username, String password);

}
