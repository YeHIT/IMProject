package cn.yesomething.controller;

import cn.yesomething.domain.Friends;
import cn.yesomething.service.FriendsServiceImpl;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("im_friends_service")
public class FriendsController {
    @Resource
    FriendsServiceImpl friendsService;

    @ResponseBody
    @RequestMapping("friends_add")
    public String addFriends(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        friendsService.addFriend(friends);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("friends_update")
    public String updateFriends(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        Friends resultFriends = friendsService.updateFriend(friends);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("friends",resultFriends);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("friends_select")
    public String selectFriends(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        Friends resultFriends = friendsService.selectByEachOther(friends);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("friends",resultFriends);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("friends_list_select")
    public String selectFriendsList(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        String userId = friends.getUserId();
        List<Friends> friendsList = friendsService.selectFriendsListByUserId(userId);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("friendsList",friendsList);
        return objectNode.toString();
    }
}
