package cn.yesomething.controller;

import cn.yesomething.service.IsLogInService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class IsLogInController {
    @Resource
    IsLogInService isLogInService;
    public String isLogIn(String [] userID){
        return this.isLogInService.isLogInService(userID);
    }
}
