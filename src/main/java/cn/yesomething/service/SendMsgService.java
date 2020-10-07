package cn.yesomething.service;

import cn.yesomething.domain.MsgBody;//消息结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.domain.UrlGenerator;
import cn.yesomething.utils.UserSigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendMsgService {
    @Value("${IMProject.SDKAppID}")
    private long sdkAppId;
    @Value("${IMProject.identifier}")
    private String identifier;

    private String userSig;


    private String url;
    public String sendMsg(int SyncOtherMachine,String From_Account,String To_Account,int MsgRandom,int MsgTimeStamp,
                          MsgBody [] Msg){
        //----------------------拼接url部分-------------------------------
        this.userSig = UserSigUtil.generateUserSig(this.identifier);
        this.url = UrlGenerator.generateUrl("v4/openim/sendmsg", this.sdkAppId, this.userSig);
        //----------------------拼接json部分------------------------------
        return null;
        //----------------------拼接结束----------------------------------
    }
}
