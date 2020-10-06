package cn.yesomething.controller;

import cn.yesomething.service.ImportOneUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ImportOneUserController {

    @Resource
    ImportOneUserService importOneUserService;


    public String importOneUser(String userId,String nickName) {
        return this.importOneUserService.importOneUser(userId,nickName);
    }

}
