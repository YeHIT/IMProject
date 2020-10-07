package cn.yesomething.service;

import cn.yesomething.domain.AddFriendItem;//添加好友结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AddFriendService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;

    private HashMap<String,String> requestMap;
    public String addFriend(String From_Account,AddFriendItem addFriendItem,String To_Account,String AddSource){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/sns/friend_add", this.sdkAppId, this.userSig);

        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------

    }
}

