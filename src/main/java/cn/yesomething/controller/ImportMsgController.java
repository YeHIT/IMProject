package cn.yesomething.controller;

import cn.yesomething.domain.MsgBody;//消息结构体（暂定），类定义文件暂时放在domain文件夹下

import cn.yesomething.service.ImportMsgService;
import cn.yesomething.service.ImportOneUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ImportMsgController {
    @Resource
    ImportMsgService importMsgService;
    public String importMsg(int SyncFromOldSystem, String From_Account, String To_Account, int MsgRandom,
                            int MsgTimeStamp, MsgBody [] Msg){
        return this.importMsgService.importMsg(SyncFromOldSystem,From_Account,To_Account,MsgRandom,
                                                MsgTimeStamp,Msg);
    }
}
