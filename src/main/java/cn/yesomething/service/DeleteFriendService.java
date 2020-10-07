package cn.yesomething.service;

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeleteFriendService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;
    public String deleteFriend(String From_Account,String To_Account,String DeleteType) {
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/sns/friend_delete", this.sdkAppId, this.userSig);
        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------

    }
}
