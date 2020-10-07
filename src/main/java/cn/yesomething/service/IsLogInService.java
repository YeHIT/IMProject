package cn.yesomething.service;

import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
//import java.util.Random;    //导入随机数

@Service
public class IsLogInService {

    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;
    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;

    private String url;

    private HashMap<String,String> requestMap;
    public String isLogInService(String [] userID){
        return this.isLogInService(userID,0);
    }
    public String isLogInService(String [] userID,int isNeedDetail){
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.randomNumber = (int)(Math.random() * RANGE);
        // url样式
        // https://console.tim.qq.com/v4/im_open_login_svc/account_check?sdkappid=88888888&identifier=admin&usersig=xxx&random=99999999&contenttype=json
        this.url = "https://console.tim.qq.com/v4/im_open_login_svc/account_check?sdkappid="
                    + Long.toString(sdkAppId)
                    + "&identifier=admin&usersig="
                    + this.userSig
                    + "&random="
                    + Long.toString(randomNumber)
                    + "&contenttype=json";
//        this.requestMap.put("")
        return null;

    }
}
