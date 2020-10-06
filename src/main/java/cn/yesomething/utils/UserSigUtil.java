package cn.yesomething.utils;

import org.springframework.beans.factory.annotation.Value;

public class UserSigUtil {

    @Value("${IMProject.SDKAppID}")
    private static long sdkAppId;

    @Value("${IMProject.secretKey}")
    private static String secretKey;

    //到期时间设为7天
    private static long expire = 60*60*24*7;

    public static String generateUserSig(String userId){
        System.out.println("111111111111111---"+sdkAppId);
        System.out.println("111111111111111---"+secretKey);
        TLSSigAPIv2 apIv2 = new TLSSigAPIv2(sdkAppId,secretKey);
        System.out.println("111111111111111---"+apIv2.genUserSig(userId,expire));
        return apIv2.genUserSig(userId,expire);
    }
}
