import cn.yesomething.dao.FriendsDao;
import cn.yesomething.domain.Friends;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestFriendsDao {
    @Resource
    FriendsDao friendsDao;

    @Test
    public void insertFriends(){
        Friends friends = new Friends("xy","xyz","heihei",null,null);
        friendsDao.insertFriends(friends);
    }

    @Test
    public void updateByEachOther(){
        Friends friends = new Friends("xy","xyz","heiheihei",null,null);
        friendsDao.updateByEachOther(friends);
    }

    @Test
    public void selectByEachOther(){
        Friends friends = new Friends("xy","xyz","heiheihei",null,null);
        System.out.println(friendsDao.selectByEachOther(friends));
    }

    @Test
    public void selectFriendsListByUserId(){
        Friends friends = new Friends("xy","xyz","heiheihei",null,null);
        System.out.println(friendsDao.selectFriendsListByUserId(friends.getUserId()));
    }
}
