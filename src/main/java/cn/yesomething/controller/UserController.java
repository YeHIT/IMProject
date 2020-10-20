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
        int result = userService.userRegister(user);
        ObjectNode objectNode = null;
        if(result == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else if(result == 1){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        }
        else if(result == 2){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"用户已存在");
        }
        else if(result == 3){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(502,"用户名密码不能为空");
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_login")
    public String userLogin(@RequestBody User user){
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        int result = userService.userLogin(userName,userPassword);
        ObjectNode objectNode = null;
        if(result == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"无此用户请注册");
        }
        else if(result == 1){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(502,"用户名或密码错误");
        }
        else{
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_update")
    public String userUpdate(@RequestBody User user){
        User resultUser =  userService.userUpdate(user);
        ObjectNode objectNode = null;
        if(resultUser == null){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("user",resultUser);
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("user_select")
    public String userInfoSelect(@RequestBody User user){
        String userName = user.getUserName();
        User resultUser = userService.userInfoSelect(userName);
        ObjectNode objectNode = null;
        if(resultUser == null){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"无此用户");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("user",resultUser);
        }
        return objectNode.toString();
    }
}
