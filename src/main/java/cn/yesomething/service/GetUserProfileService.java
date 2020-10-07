package cn.yesomething.service;

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;

public class GetUserProfileService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;
    public String getUserProfile(String userID,String [] TagList){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/profile/portrait_get", this.sdkAppId, this.userSig);
        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------
    }
}
