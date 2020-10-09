package cn.yesomething.dao;

import cn.yesomething.domain.Friends;
import java.util.List;

public interface FriendsDao {
    int deleteByPrimaryKey(Integer friendsId);

    int insert(Friends record);

    Friends selectByPrimaryKey(Integer friendsId);

    List<Friends> selectAll();

    int updateByPrimaryKey(Friends record);
}