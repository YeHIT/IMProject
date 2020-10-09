package cn.yesomething.dao;

import cn.yesomething.domain.Message;
import java.util.List;

public interface MessageDao {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    Message selectByPrimaryKey(Integer messageId);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);
}