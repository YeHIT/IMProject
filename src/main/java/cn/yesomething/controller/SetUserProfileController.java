package cn.yesomething.controller;

import cn.yesomething.domain.ProfileItem;//用户资料结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.service.SetUserProfileService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class SetUserProfileController {
    @Resource
    SetUserProfileService setUserProfileService;
    public String setUserProfile(String From_Account,ProfileItem profile){
        return this.setUserProfileService.setUserProfile(From_Account,profile);
    }
}
