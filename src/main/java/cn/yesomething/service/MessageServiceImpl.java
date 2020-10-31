package cn.yesomething.service;

import cn.yesomething.Exception.DateParseException;
import cn.yesomething.Exception.NoMessageException;
import cn.yesomething.Exception.UnknownException;
import cn.yesomething.dao.MessageDao;
import cn.yesomething.domain.Message;
import cn.yesomething.utils.JsonObjectValueGetter;
import cn.yesomething.utils.PictureHandler;
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

    public static final int TEXT_MESSAGE = 1;
    public static final int PICTURE_MESSAGE = 2;
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
            throw new NoMessageException("从" + messageEndDate + "到" + messageEndDate + fromId + "和" + toId + "间无消息");
        }
        return messageDao.selectByStartTimeAndEndTime(fromId,toId,messageStartDate,messageEndDate);
    }

    /**
     * 插入消息
     * @param message 要插入的消息
     */
    @Override
    public void insertMessage(Message message) {
        Integer messageContentType = message.getMessageContentType();
        //文本消息直接插入
        if(messageContentType == null || messageContentType == TEXT_MESSAGE){
            messageDao.insertMessage(message);
        }
        //图片消息
        else if(messageContentType == PICTURE_MESSAGE){
            String userName = message.getFromId();
            String messageContent = message.getMessageContent();
            //存放图片获取图片在服务器的地址
            String messageUrl = PictureHandler.upLoadPictureToFileFolder(userName,messageContent,PictureHandler.MESSAGE_PICTURE);
            if(messageUrl == null){
                throw new UnknownException("上传消息图片时遇到未知错误,当前图片为"+messageContent);
            }
            message.setMessageContent(messageUrl);
            messageDao.insertMessage(message);
        }
    }
}
