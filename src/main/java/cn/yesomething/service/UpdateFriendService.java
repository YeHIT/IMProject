package cn.yesomething.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UpdateFriendService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;
    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;
    private String url;
//    public String updateFriend();
}
