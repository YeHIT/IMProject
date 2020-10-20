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
        int result = friendsService.addFriend(friends);
        if(result == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else if(result == 1){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        }
        else{
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"已为好友,请勿重复添加");
        }
        return objectNode.toString();
    }
    @ResponseBody
    @RequestMapping("friends_update")
    public String updateFriends(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        Friends resultFriends = friendsService.updateFriend(friends);
        if(resultFriends == null){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("friends",resultFriends);
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("friends_select")
    public String selectFriends(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        Friends resultFriends = friendsService.selectByEachOther(friends);
        if(resultFriends == null){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"并非好友关系");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("friends",resultFriends);
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("friends_list_select")
    public String selectFriendsList(@RequestBody Friends friends){
        ObjectNode objectNode = null;
        String userId = friends.getUserId();
        List<Friends> friendsList = friendsService.selectFriendsListByUserId(userId);
        if(friendsList.size() == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"未和任何人有好友关系");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("friendsList",friendsList);
        }
        return objectNode.toString();
    }
}
