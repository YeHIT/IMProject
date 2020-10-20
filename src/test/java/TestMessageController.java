import cn.yesomething.controller.MessageController;
import cn.yesomething.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TestMessageController {
    @Resource
    MessageController messageController;

    @Test
    public void testSelectMessageByTime(){
        //{"fromId":"11","toId":"22"}
        String selectConditionJson = "{\"fromId\":\"11\",\"toId\":\"22\"}";
        String result = messageController.selectMessageByTime(selectConditionJson);
        System.out.println(result);
    }

    @Test
    public void testInsertMessage(){
        Message message = new Message("11","22",new Date(),"hi",null);
        String result = messageController.insertMessage(message);
        System.out.println(result);
    }
}
