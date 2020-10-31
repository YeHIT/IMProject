package cn.yesomething.controller;

import cn.yesomething.domain.User;
import cn.yesomething.service.GeneralServiceImpl;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("im_general_service")
public class GeneralController {
    @Resource
    GeneralServiceImpl generalService;

    @ResponseBody
    @RequestMapping("generate_user_sig")
    public String generateUserSig(@RequestBody User user) {
        String userName = user.getUserName();
        String userSig = generalService.generateUserSig(userName);
        //创建json对象
        ObjectNode objectNode = null;
        objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
        objectNode.put("userSig",userSig);
        return objectNode.toString();
    }
}
