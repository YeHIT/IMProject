package cn.yesomething.controller;

import cn.yesomething.domain.Message;
import cn.yesomething.service.MessageServiceImpl;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("im_message_service")
public class MessageController {
    @Resource
    MessageServiceImpl messageService;

    @ResponseBody
    @RequestMapping("message_select")
    public String selectMessageByTime(@RequestBody String selectConditionJson) {
        System.out.println(selectConditionJson);
        ObjectNode objectNode = null;
        String fromId = JsonObjectValueGetter.getJsonValue(selectConditionJson,"fromId");
        String toId = JsonObjectValueGetter.getJsonValue(selectConditionJson,"toId");
        //传入了起止时间才将其转型为Date
        String startTime = JsonObjectValueGetter.getJsonValue(selectConditionJson,"messageStartTime");
        Date messageStartTime = null;
        String endTime = JsonObjectValueGetter.getJsonValue(selectConditionJson,"messageEndTime");
        Date messageEndTime = null;
        try {
            if(startTime != null && !startTime.equals("")){
                messageStartTime = new SimpleDateFormat().parse(startTime);
            }
            if(endTime != null && !endTime.equals("")){
                messageEndTime = new SimpleDateFormat().parse(endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Message> messageList = messageService.selectMessageByTime(
                fromId,toId, messageStartTime,messageEndTime);
        if(messageList.size() == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"当前时间段无历史消息,请换一个时间段");
        }
        else{
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("messageList",messageList);
        }
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("message_insert")
    public String insertMessage(@RequestBody Message message) {
        ObjectNode objectNode = null;
        int result = messageService.insertMessage(message);
        if(result == 0){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        }
        return objectNode.toString();
    }
}
