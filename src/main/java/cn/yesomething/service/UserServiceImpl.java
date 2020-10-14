package cn.yesomething.service;

import cn.yesomething.dao.UserDao;
import cn.yesomething.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao userDao;
    /**
     * 根据用户名和密码注册
     * @param userName 用户名
     * @param password 密码
     * @return 返回本次注册的结果
     */
    public int userRegister(String userName, String password) {
        User user = new User(userName,password);
        return userDao.insertSelective(user);
    }

    /**
     * 根据用户名和密码登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回本次登录的结果
     */
    public int userLogin(String userName, String password) {
        String truePassword = userDao.selectPasswordByUserName(userName);
        //数据库无此用户
        if(truePassword == null){
            return 0;
        }
        //密码不匹配
        else if(!truePassword.equals(password)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    /**
     * 根据传入的User对象更新数据库
     *
     * @param user 要更新的User对象
     * @return 返回更新后的User对象
     */
    public User userUpdate(User user) {
        return null;
    }


}
