import cn.yesomething.controller.FriendsController;
import cn.yesomething.domain.Friends;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TestFriendsController {
    @Resource
    FriendsController friendsController;

    @Test
    public void testAddFriends(){
        Friends friends = new Friends("xy","xyz","heihei",null,null);
        System.out.println(friendsController.addFriends(friends));
    }

    @Test
    public void testUpdateFriends(){
        Friends friends = new Friends("xy1","xyz","heihei",null,null);
        System.out.println(friendsController.updateFriends(friends));
    }

    @Test
    public void testSelectFriends(){
        Friends friends = new Friends("xy","xyz","heihei",null,null);
        System.out.println(friendsController.selectFriends(friends));
    }

    @Test
    public void testSelectFriendsList(){
        Friends friends = new Friends("xy","xyz","heihei",null,null);
        System.out.println(friendsController.selectFriendsList(friends));
    }
}
