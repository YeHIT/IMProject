package cn.yesomething.service;

import cn.yesomething.utils.UrlGenerator;
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


    private String url;

    private HashMap<String,String> requestMap = new HashMap();

    public String importOneUser(String userId){
        return this.importOneUser(userId,null);
    }


    public String importOneUser(String userId,String nickName) {
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/im_open_login_svc/account_import", this.sdkAppId, this.userSig);

        this.requestMap.put("Identifier",this.identifier);
        if(nickName != null){
            this.requestMap.put("Nick",nickName);
        }
        try {
            MyImProjectLogger.LOGGER.info(MyServerToIMServerSender.sendPost(this.url,this.requestMap));
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
