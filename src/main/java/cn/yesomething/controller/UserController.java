package cn.yesomething.controller;

import cn.yesomething.service.UserServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserServiceImpl userService;


}
