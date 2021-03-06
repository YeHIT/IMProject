import cn.yesomething.dao.UserDao;
import cn.yesomething.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestUserDao {
    @Resource
    UserDao userDao;

    public static final Logger LOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    public void testInsertSelective(){
        User user = new User();
        user.setUserName("xyzb");
        user.setUserPassword("123");
        user.setUserSex(1);
        user.setUserNickname(null);
        user.setUserBirthday(new Date());
        user.setUserPicture(null);
        userDao.insertSelective(user);
    }

    @Test
    public void testDeleteByUserName(){
        userDao.deleteByUserName("xyzb");
    }

    @Test
    public void testUpdateByUserNameSelective(){
        User user = new User();
        user.setUserName("xyzby");
        user.setUserPassword("123");
        user.setUserSex(1);
        user.setUserNickname(null);
        user.setUserBirthday(new Date());
        user.setUserPicture(null);
        user.setUserHistoricalPictures(new String[]{"aaaa","bbbbb","ccccc"});
        userDao.updateByUserNameSelective(user);
    }

    @Test
    public void testSelectByUserName(){
        System.out.println(userDao.selectByUserName("xyzby"));
    }

    @Test
    public void testSelectByUserNickname(){
        System.out.println(userDao.selectByUserNickname("111"));
    }

    @Test
    public void testSelectAll(){
        System.out.println(userDao.selectAll());
    }

    @Test
    public void testSelectPasswordByUserName(){
        System.out.println(userDao.selectPasswordByUserName("xyzb"));
    }
}
