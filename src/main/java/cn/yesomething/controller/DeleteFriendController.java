package cn.yesomething.controller;

import cn.yesomething.service.DeleteFriendService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DeleteFriendController {
    @Resource
    DeleteFriendService deleteFriendService;
    String DefaultType = "Delete_Type_Both";//默认删除方式，双向删除
    public String deleteFriend(String From_Account,String To_Account,String DeleteType){
        return this.deleteFriendService.deleteFriend(From_Account,To_Account,this.DefaultType);
    }
}
