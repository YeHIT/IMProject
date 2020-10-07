package cn.yesomething.service;

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


//import java.util.Random;    //导入随机数

@Service
public class IsLogInService {

    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;

    public String isLogInService(String [] userID){
        return this.isLogInService(userID,0);
    }
    public String isLogInService(String [] userID,int isNeedDetail){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/openim/querystate", this.sdkAppId, this.userSig);
        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------

    }
}
