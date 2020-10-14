package cn.yesomething.service;

import cn.yesomething.domain.User;

public interface UserService {

    /**
     * 根据用户名和密码注册
     * @param userName 用户名
     * @param password 密码
     * @return 返回本次注册的结果
     */
    int userRegister(String userName,String password);


    /**
     * 根据用户名和密码登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回本次登录的结果
     */
    int userLogin(String userName,String password);

    /**
     * 根据传入的User对象更新数据库
     * @param user 要更新的User对象
     * @return 返回更新后的User对象
     */
    User userUpdate(User user);

}
