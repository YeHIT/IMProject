package cn.yesomething.service;

import cn.yesomething.domain.User;

public interface UserService {

    /**
     * 用户注册
     * @param user 需要注册的用户对象
     * @return 返回本次注册的结果
     */
    int userRegister(User user);

    /**
     * 根据用户名和密码注册
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return 返回本次注册的结果
     */
    int userRegister(String userName, String userPassword) ;

    /**
     * 根据用户名和密码登录
     * @param userName 用户名
     * @param userPassword 密码
     * @return 返回本次登录的结果
     */
    int userLogin(String userName, String userPassword);

    /**
     * 根据传入的User对象更新数据库
     * @param user 要更新的User对象
     * @return 返回更新后的User对象
     */
    User userUpdate(User user);


    /**
     * 根据用户名查找对应的用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    User userInfoSelect(String userName);

}
