package cn.yesomething.controller;

import cn.yesomething.service.AccountDeleteService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AccountDeleteController {
    @Resource
    AccountDeleteService accountDeleteService;
    public String accountDelete(String [] userId){
        return this.accountDeleteService.accountDelete(userId);
    }
}
