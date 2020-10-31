package cn.yesomething.service;

import cn.yesomething.Exception.*;
import cn.yesomething.dao.UserDao;
import cn.yesomething.domain.User;
import cn.yesomething.utils.PictureHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao userDao;
    //最大历史头像数
    private static final int MAX_PICTURES_NUMBER = 15;

    /**
     * 用户注册
     * @param user 需要注册的用户对象
     */
    @Override
    public void userRegister(User user){
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        //用户名密码不能为空
        if(userName == null || userName.equals("") ||  userPassword == null || userPassword.equals("")){
            throw new UserNameIsNullException("用户名密码不能为空,输入用户名为:" + userName + ",密码为:" + userPassword);
        }
        User resultUser = userDao.selectByUserName(userName);
        //存在该用户
        if(resultUser != null){
            throw new UserExistException(userName + "用户已存在");
        }
        userDao.insertSelective(user);
    }

    /**
     * 根据用户名和密码注册
     * @param userName 用户名
     * @param userPassword 用户密码
     */
    public void userRegister(String userName, String userPassword){
        User user = new User(userName,userPassword);
        this.userRegister(user);
    }

    /**
     * 根据用户名和密码登录
     * @param userName 用户名
     * @param userPassword 密码
     */
    public void userLogin(String userName, String userPassword){
        String truePassword = userDao.selectPasswordByUserName(userName);
        //数据库无此用户
        if(truePassword == null){
            throw new NoSuchUserException("数据库中没有该用户:" + userName);
        }
        //密码不匹配
        else if(!truePassword.equals(userPassword)) {
            throw new PasswordErrorException("用户名或密码错误,输入用户名为:" + userName + ",密码为:" + userPassword);
        }
    }

    /**
     * 根据传入的User对象更新数据库
     * @param user 要更新的User对象
     * @return 返回更新后的User对象
     */
    public User userUpdate(User user){
        //先查看有无此用户
        this.userInfoSelect(user.getUserName());
        int result = userDao.updateByUserNameSelective(user);
        if(result == 1){
            return userInfoSelect(user.getUserName());
        }
        else {
            throw new InfoNoChangeException(user + "当前资料均为最新版");
        }
    }

    /**
     * 根据用户名查找对应的用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    @Override
    public User userInfoSelect(String userName){
        User user = userDao.selectByUserName(userName);
        if(user == null){
            throw new NoSuchUserException("数据库中没有该用户:"+userName);
        }
        return user;
    }

    /**
     * 用户头像上传
     * @param userName 用户名
     * @param base64pictureContent 使用base64编码的用户头像内容
     * @return 返回用户头像所对应的链接
     */
    @Override
    public String userPictureUpload(String userName,String base64pictureContent) {
        //查看有无该用户
        User user = this.userInfoSelect(userName);
        String pictureUrl = PictureHandler.upLoadPictureToFileFolder(userName,base64pictureContent);
        //放置图片失败
        if(pictureUrl == null){
            throw new UnknownException("上传用户头像时遇到未知错误,当前图片为"+base64pictureContent);
        }
        else{
            //设置当前头像
            user.setUserPicture(pictureUrl);
            //获取历史头像
            String[] historicalPictures = user.getUserHistoricalPictures();
            //历史头像为空时直接更新
            if(historicalPictures == null){
                historicalPictures = new String[]{pictureUrl};
            }
            else {
                //历史头像非空时通过ArrayList更新
                ArrayList<String> pictureArrayList = new ArrayList(Arrays.asList(historicalPictures));
                //如果历史图片数大于最大数,移除第一张图片
                if (pictureArrayList.size() > MAX_PICTURES_NUMBER) {
                    pictureArrayList.remove(0);
                }
                pictureArrayList.add(pictureUrl);
                historicalPictures = pictureArrayList.toArray(historicalPictures);
            }
            user.setUserHistoricalPictures(historicalPictures);
            this.userUpdate(user);
            return pictureUrl;
        }
    }
}
