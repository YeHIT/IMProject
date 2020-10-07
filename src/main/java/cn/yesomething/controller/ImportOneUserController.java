package cn.yesomething.controller;

import cn.yesomething.service.ImportOneUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ImportOneUserController {

    @Resource
    ImportOneUserService importOneUserService;


    @RequestMapping("getUserSig")
    public String importOneUser(String userId,String nickName) {
        return this.importOneUserService.importOneUser(userId,nickName);
    }

}
