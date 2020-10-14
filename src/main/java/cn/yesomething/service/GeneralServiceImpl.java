package cn.yesomething.service;

import cn.yesomething.utils.TLSSigAPIv2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeneralServiceImpl implements GeneralService{

    private static long sdkAppId;

    private static String secretKey;

    //到期时间设为7天
    private static long expire = 60*60*24*7;

    public static long getSdkAppId() {
        return sdkAppId;
    }

    @Value("${IMProject.SDKAppID}")
    public void setSdkAppId(long sdkAppId) {
        GeneralServiceImpl.sdkAppId = sdkAppId;
    }

    public static String getSecretKey() {
        return secretKey;
    }
    @Value("${IMProject.secretKey}")
    public void setSecretKey(String secretKey) {
        GeneralServiceImpl.secretKey = secretKey;
    }

    /**
     * @param userId 需要产生usersig的ID
     * @return 返回产生的usersig
     */
    @Override
    public String generateUserSig(String userId) {
        TLSSigAPIv2 apIv2 = new TLSSigAPIv2(sdkAppId,secretKey);
        return apIv2.genUserSig(userId,expire);
    }
}
