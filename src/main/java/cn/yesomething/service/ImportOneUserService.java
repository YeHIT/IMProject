package cn.yesomething.service;

import cn.yesomething.controller.UserSigController;
import cn.yesomething.domain.LinkedJsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class ImportOneUserService {

    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;

    @Value("{IMProject.identifier}")
    private String identifier;

    @Resource
    private UserSigController userSigController;

    private String userSig ;

    private long randomNumber;

    private String url;

    private HashMap<String,String> requestMap;

    public String importOneUser(String userId){
        return this.importOneUser(userId,null);
    }


    public String importOneUser(String userId,String nickName) {
        this.userSig = userSigController.getUserSig(this.identifier);
//        randomNumber = xxxx;
        this.url = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?";

        this.requestMap.put("Identifier",this.identifier);
        if(nickName != null){
            this.requestMap.put("Nick",nickName);
        }

        //装载配置好的url及请求包的对象
        LinkedJsonObject linkedJsonObject = new LinkedJsonObject(this.url,this.requestMap);

        //Json格式转换Mapper
        ObjectMapper objectMapper = new ObjectMapper();
        String linkedJsonObjectJson = null;
        try {
            linkedJsonObjectJson = objectMapper.writeValueAsString(linkedJsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return linkedJsonObjectJson;
    }
}
