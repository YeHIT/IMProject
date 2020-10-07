package cn.yesomething.controller;

import cn.yesomething.domain.MsgBody;//消息结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.domain.MsgBody;
import cn.yesomething.service.SendMsgService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class SendMsgController {
    @Resource
    SendMsgService sendMsgService;
    public String sendMsg(int SyncOtherMachine,String From_Account,String To_Account,int MsgRandom,int MsgTimeStamp,
                          MsgBody[] Msg){
        return this.sendMsg(SyncOtherMachine,From_Account,To_Account,MsgRandom,MsgTimeStamp,Msg);
    }
}
