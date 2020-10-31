package cn.yesomething.dao;

import cn.yesomething.domain.Friends;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsDao {

    int insertFriends(Friends friends);

    int updateByEachOther(Friends friends);

    Friends selectByEachOther(Friends friends);

    List<Friends> selectFriendsListByUserId(String userId);

    List<Friends> selectAll();

}