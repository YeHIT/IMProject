import cn.yesomething.controller.UserController;
import cn.yesomething.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TestUserController {
    @Resource
    UserController userController;

    @Test
    public void testUserRegister(){
        User user = new User("zzz","123");
        String result = userController.userRegister(user);
        System.out.println(result);
    }

    @Test
    public void testUserLogin() {
        User user = new User("zzz","1923");
        String result = userController.userLogin(user);
        System.out.println(result);
    }

    @Test
    public void testUserUpdate(){
        User user = new User("zzz","123");
        String result = userController.userUpdate(user);
        System.out.println(result);
    }

    @Test
    public void testUserInfoSelect(){
        User user = new User("zzz","123");
        String result = userController.userInfoSelect(user);
        System.out.println(result);
    }

    @Test
    public void testUserPictureUpload(){
        String pictureJson = "{\"userName\":\"denwade\",\"base64String\":\"xx\"}";
        userController.userPictureUpload(pictureJson);
    }

    @Test
    public void testUserWordCloudGenerate(){
        User user = new User();
        user.setUserName("denwade");
        String result = userController.userWordCloudGenerate(user);
        System.out.println(result);
    }
}
