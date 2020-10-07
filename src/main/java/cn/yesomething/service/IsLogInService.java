package cn.yesomething.service;

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
    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;

    private String url;

    public String isLogInService(String [] userID){
        return this.isLogInService(userID,0);
    }
    public String isLogInService(String [] userID,int isNeedDetail){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.randomNumber = (int) (Math.random() * this.RANGE);
        this.url = "https://console.tim.qq.com/v4/openim/querystate?sdkappid="
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
