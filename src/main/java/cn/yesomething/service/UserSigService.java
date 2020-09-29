package cn.yesomething.service;

import cn.yesomething.utils.TLSSigAPIv2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserSigService {

    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;

    @Value("${IMProject.secretKey}")
    private String secretKey;

    //到期时间设为7天
    private long expire = 60*60*24*7;

    public String generateUserSig(String userId){
        System.out.println("111111111111111---"+sdkAppId);
        System.out.println("111111111111111---"+secretKey);
        TLSSigAPIv2 apIv2 = new TLSSigAPIv2(sdkAppId,secretKey);
        System.out.println("111111111111111---"+apIv2.genUserSig(userId,expire));
        return apIv2.genUserSig(userId,expire);
    }
}
