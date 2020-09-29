package cn.yesomething.controller;

import cn.yesomething.service.UserSigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserSigController {

    @Resource
    UserSigService userSigService;

    @RequestMapping("/getUserSig")
    public String getUserSig(String userId){
        return userSigService.generateUserSig(userId);
    }
}
