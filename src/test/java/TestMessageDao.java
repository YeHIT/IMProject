import cn.yesomething.dao.MessageDao;
import cn.yesomething.domain.Message;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestMessageDao {
    @Resource
    MessageDao messageDao;

    @Test
    public void testSelectMessage(){
        String fromId = "11";
        String toId = "22" ;
        List<Message> messageList = messageDao.selectByStartTimeAndEndTime(
                fromId,toId,null,null);
        System.out.println(messageList);
    }

    @Test
    public void testInsertMessage(){
        String fromId = "11";
        String toId = "22" ;
        Message message = new Message();
        message.setFromId("11");
        message.setToId("22");
        message.setMessageTime(new Date());
        message.setMessageContent("hi");
        message.setMessageContentType(null);
        message.setMessageEmotionalScore(0.5);
        message.setProcessedContent(null);
        message.setHasViolentInfo(0);
        System.out.println(messageDao.insertMessage(message));
    }
}
