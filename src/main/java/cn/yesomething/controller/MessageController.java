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
        ObjectNode objectNode = null;
        //获取需要的变量
        String fromId = JsonObjectValueGetter.getJsonValue(selectConditionJson,"fromId");
        String toId = JsonObjectValueGetter.getJsonValue(selectConditionJson,"toId");
        String startTime = JsonObjectValueGetter.getJsonValue(selectConditionJson,"messageStartTime");
        String endTime = JsonObjectValueGetter.getJsonValue(selectConditionJson,"messageEndTime");
        //执行查找操作
        List<Message> messageList = messageService.selectMessageByTime(fromId,toId, startTime,endTime);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.putPOJO("messageList",messageList);
        return objectNode.toString();
    }

    @ResponseBody
    @RequestMapping("message_insert")
    public String insertMessage(@RequestBody Message message) {
        ObjectNode objectNode = null;
        messageService.insertMessage(message);
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        return objectNode.toString();
    }
}
