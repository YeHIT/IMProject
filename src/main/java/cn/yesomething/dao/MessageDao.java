package cn.yesomething.dao;

import cn.yesomething.domain.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageDao {

    int insertMessage(Message message);

    List<Message> selectByStartTimeAndEndTime(@Param("fromId")String fromId, @Param("toId")String toId,
                                              @Param("messageStartTime")Date messageStartTime,
                                              @Param("messageEndTime")Date messageEndTime);

    List<Message> selectAll();



}