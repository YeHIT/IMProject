package cn.yesomething.service;

import cn.yesomething.Exception.DateParseException;
import cn.yesomething.Exception.NoMessageException;
import cn.yesomething.dao.MessageDao;
import cn.yesomething.domain.Message;
import cn.yesomething.utils.JsonObjectValueGetter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Resource
    MessageDao messageDao;

    /**
     * 按输入的时间查询两人间的消息
     * @param fromId           消息发出者
     * @param toId             消息接收者
     * @param messageStartTime 开始时间
     * @param messageEndTime   结束时间
     * @return 在开始时间与结束时间间二者之间的消息
     */
    @Override
    public List<Message> selectMessageByTime(String fromId, String toId,
                                             String messageStartTime, String messageEndTime) {
        Date messageStartDate = null;
        Date messageEndDate = null;
        try {
            if(messageStartTime != null && !messageStartTime.equals("")){
                messageStartDate = new SimpleDateFormat().parse(messageStartTime);
            }
            if(messageStartTime != null && !messageEndTime.equals("")){
                messageEndDate = new SimpleDateFormat().parse(messageEndTime);
            }
        } catch (ParseException e) {
            throw new DateParseException("日期处理失败");
        }
        List<Message> messageList = messageDao.selectByStartTimeAndEndTime(fromId,toId,messageStartDate,messageEndDate);
        if(messageList.size() == 0){
            throw new NoMessageException("从" + messageEndDate + "到" + messageEndTime + fromId + "和" + toId + "间无消息");
        }
        return messageDao.selectByStartTimeAndEndTime(fromId,toId,messageStartDate,messageEndDate);
    }

    /**
     * 插入消息
     * @param message 要插入的消息
     * @return 插入操作是否成功
     */
    @Override
    public int insertMessage(Message message) {
        return messageDao.insertMessage(message);
    }
}
