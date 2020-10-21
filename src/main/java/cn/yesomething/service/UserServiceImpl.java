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
     * 用户注册
     * @param user 需要注册的用户对象
     * @return 返回本次注册的结果
     */
    @Override
    public int userRegister(User user) {
        User resultUser = userDao.selectByUserName(user.getUserName());
        //用户名密码不能为空
        if(user.getUserName() == null || user.getUserName().equals("")
                ||  user.getUserPassword() == null || user.getUserPassword().equals("")){
            return 3;
        }
        //存在该用户
        else if(resultUser != null){
            return 2;
        }
        else {
            return userDao.insertSelective(user);
        }
    }

    /**
     * 根据用户名和密码注册
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return 返回本次注册的结果
     */
    public int userRegister(String userName, String userPassword) {
        User user = new User(userName,userPassword);
        return this.userRegister(user);
    }



    /**
     * 根据用户名和密码登录
     * @param userName 用户名
     * @param userPassword 密码
     * @return 返回本次登录的结果
     */
    public int userLogin(String userName, String userPassword) {
        String truePassword = userDao.selectPasswordByUserName(userName);
        //数据库无此用户
        if(truePassword == null){
            return 0;
        }
        //密码不匹配
        else if(!truePassword.equals(userPassword)) {
            return 1;
        }
        else {
            return 2;
        }
    }

    /**
     * 根据传入的User对象更新数据库
     * @param user 要更新的User对象
     * @return 返回更新后的User对象
     */
    public User userUpdate(User user) {
        int result = userDao.updateByUserNameSelective(user);
        if(result == 1){
            return userDao.selectByUserName(user.getUserName());
        }
        else {
            return null;
        }
    }

    /**
     * 根据用户名查找对应的用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    @Override
    public User userInfoSelect(String userName) {
        return userDao.selectByUserName(userName);
    }


}
