package cn.yesomething.controller;

import cn.yesomething.domain.AddFriendItem;//添加好友结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.domain.AddFriendItem;
import cn.yesomething.service.AddFriendService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AddFriendController {
    @Resource
    AddFriendService addFriendService;
    public String addFriend(String From_Account, AddFriendItem addFriendItem, String To_Account, String AddSource){
        return this.addFriendService.addFriend(From_Account,addFriendItem,To_Account,AddSource);
    }
}
