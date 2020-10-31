package cn.yesomething.controller;

import cn.yesomething.domain.User;
import cn.yesomething.service.UserServiceImpl;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("im_user_service")
public class UserController {

    @Resource
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("user_register")
    public String userRegister(@RequestBody User user){
        userService.userRegister(user);
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_login")
    public String userLogin(@RequestBody User user){
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        userService.userLogin(userName,userPassword);
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_update")
    public String userUpdate(@RequestBody User user){
        User resultUser =  userService.userUpdate(user);
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("user",resultUser);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_select")
    public String userInfoSelect(@RequestBody User user){
        String userName = user.getUserName();
        User resultUser = userService.userInfoSelect(userName);
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("user",resultUser);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_picture_upload")
    public String userPictureUpload(@RequestBody String pictureJson){
        String userName = JsonObjectValueGetter.getJsonValue(pictureJson,"userName");
        String base64String = JsonObjectValueGetter.getJsonValue(pictureJson,"base64String");
        String resultUrl = userService.userPictureUpload(userName,base64String);
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("userPicture",resultUrl);
        return objectNode.toString();
    }
}
