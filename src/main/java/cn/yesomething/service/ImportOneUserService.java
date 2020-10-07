package cn.yesomething.service;

import cn.yesomething.utils.MyImProjectLogger;
import cn.yesomething.utils.MyServerToIMServerSender;
import cn.yesomething.utils.UserSigUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ImportOneUserService {

    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;

    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig ;

    private long randomNumber;

    private String url;

    private HashMap<String,String> requestMap = new HashMap();

    public String importOneUser(String userId){
        return this.importOneUser(userId,null);
    }


    public String importOneUser(String userId,String nickName) {
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
//        randomNumber = xxxx;
        this.url = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?sdkappid=" +
                this.sdkAppId + "&identifier=" + this.identifier + "&usersig=" +
                this.userSig + "&random=99999999&contenttype=json";

        this.requestMap.put("Identifier",userId);
        if(nickName != null){
            this.requestMap.put("Nick",nickName);
        }

        try {
            MyImProjectLogger.LOGGER.info(MyServerToIMServerSender.sendPost(url,requestMap));
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Json格式转换Mapper
        ObjectMapper objectMapper = new ObjectMapper();
        String linkedJsonObjectJson = null;
        try {
           linkedJsonObjectJson = objectMapper.writeValueAsString(requestMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            MyImProjectLogger.LOGGER.debug(linkedJsonObjectJson);
            return linkedJsonObjectJson;
        }
    }
}
