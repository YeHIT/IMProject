package cn.yesomething.service;

import cn.yesomething.domain.Message;

import java.util.List;

public interface MessageService {

    /**
     * 按输入的时间查询两人间的消息
     * @param fromId 消息发出者
     * @param toId 消息接收者
     * @param messageStartTime 开始时间
     * @param messageEndTime 结束时间
     * @return 在开始时间与结束时间间二者之间的消息
     */
    List<Message> selectMessageByTime(String fromId, String toId,
                                      String messageStartTime,String messageEndTime);

    /**
     * 插入消息
     * @param message 要插入的消息
     * @return 刚刚插入的消息
     */
    Message insertMessage(Message message);
}
