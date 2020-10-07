package cn.yesomething.service;

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AccountDeleteService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;

    public String accountDelete(String[] userId) {
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/im_open_login_svc/account_delete", this.sdkAppId, this.userSig);
        return null;
    }
}

