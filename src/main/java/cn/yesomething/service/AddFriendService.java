package cn.yesomething.service;

import cn.yesomething.domain.AddFriendItem;//添加好友结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.domain.LinkedJsonObject;
import cn.yesomething.utils.UserSigUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class AddFriendService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier")
    private String identifier;
    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;
    private String url;

    private HashMap<String,String> requestMap;
    public String addFriend(String From_Account,AddFriendItem addFriendItem,String To_Account,String AddSource){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.randomNumber = (int)(Math.random() * this.RANGE);
        this.url = "https://console.tim.qq.com/v4/sns/friend_add?sdkappid="
                + Long.toString(this.sdkAppId)
                + "&identifier=admin&usersig="
                + this.userSig
                + "&random="
                + Long.toString(this.randomNumber)
                + "&contenttype=json";

        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------

    }
}

