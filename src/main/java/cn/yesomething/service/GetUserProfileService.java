package cn.yesomething.service;

import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;

public class GetUserProfileService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;
    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;
    private String url;
    public String getUserProfile(String userID,String [] TagList){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.randomNumber = (int) (Math.random() * this.RANGE);
        this.url = "https://console.tim.qq.com/v4/profile/portrait_get?sdkappid="
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
