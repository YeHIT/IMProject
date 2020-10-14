package cn.yesomething.controller;

import cn.yesomething.service.GeneralServiceImpl;
import cn.yesomething.utils.JsonObjectValueGetter;
import org.json.JSONObject;
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

    @RequestMapping("/generate_usersig")
    @ResponseBody
    public String generateUserSig(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        String userId = JsonObjectValueGetter.getJsonValue(jsonStr,"userName");
        System.out.println(generalService.generateUserSig(userId));
        return generalService.generateUserSig(userId);
    }
}
