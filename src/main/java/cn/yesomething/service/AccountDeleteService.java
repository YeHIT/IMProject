package cn.yesomething.service;

import cn.yesomething.domain.LinkedJsonObject;
import cn.yesomething.utils.UserSigUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class AccountDeleteService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig ;

    private final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private long randomNumber;
    private String url;

    private HashMap<String,String> requestMap;
    public String accountDelete(String [] userId){
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.randomNumber = (int)(Math.random() * RANGE);
        this.url = "https://console.tim.qq.com/v4/im_open_login_svc/account_delete?sdkappid="
                + Long.toString(this.sdkAppId)
                + "&identifier=admin&usersig="
                + this.userSig
                + "&random="
                + Long.toString(this.randomNumber)
                + "&contenttype=json";
        this.requestMap.put("Identifier",this.identifier);


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

