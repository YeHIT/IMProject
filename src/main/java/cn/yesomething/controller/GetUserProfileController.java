package cn.yesomething.controller;

import cn.yesomething.service.GetUserProfileService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class GetUserProfileController {
    @Resource
    GetUserProfileService getUserProfileService;
    public String getUserProfile(String userID,String [] TagList){
        return this.getUserProfileService.getUserProfile(userID,TagList);
    }
}
