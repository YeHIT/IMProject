package cn.yesomething.service;

import cn.yesomething.Exception.FriendRepeatException;
import cn.yesomething.Exception.InfoNoChangeException;
import cn.yesomething.Exception.NoFriendListException;
import cn.yesomething.Exception.NoFriendRelationException;
import cn.yesomething.dao.FriendsDao;
import cn.yesomething.domain.Friends;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService{

    @Resource
    FriendsDao friendsDao;

    /**
     * 添加好友
     * @param friends 需要添加的好友关系
     */
    @Override
    public void addFriend(Friends friends) {
        Friends resultFriends = friendsDao.selectByEachOther(friends);
        Friends antiFriends = new Friends(friends.getUserId(),friends.getFriendId(),
                friends.getUserId(),friends.getFriendType(),friends.getFriendGroupType());
        if(resultFriends == null){
            friendsDao.insertFriends(friends);
            friendsDao.insertFriends(antiFriends);
        }
        else {        //二者已经是好友了
            throw new FriendRepeatException(friends.getUserId() + "和" + friends.getFriendId() + "已为好友关系");
        }
    }

    /**
     * 更新好友信息
     * @param friends 需要更新的好友信息
     * @return 更新后的好友信息
     */
    @Override
    public Friends updateFriend(Friends friends) {
        this.selectByEachOther(friends);
        int result = friendsDao.updateByEachOther(friends);
        if(result == 1){
            return friendsDao.selectByEachOther(friends);
        }
        else {
            throw new InfoNoChangeException(friends + "当前资料已为最新版本");
        }
    }

    /**
     * 根据双方名字查询好友信息
     * @param friends 需要查询的好友信息
     * @return 好友信息
     */
    @Override
    public Friends selectByEachOther(Friends friends) {
        Friends resultFriends = friendsDao.selectByEachOther(friends);
        if(resultFriends == null){
            throw new NoFriendRelationException(friends.getUserId() + "和" + friends.getFriendId() + "不为好友关系");
        }
        else {
            return resultFriends;
        }
    }

    /**
     * 根据userId查询他的全部好友信息
     * @param userId 需要查询的人
     * @return 全部好友信息
     */
    @Override
    public List<Friends> selectFriendsListByUserId(String userId) {
        List<Friends> friendsList = friendsDao.selectFriendsListByUserId(userId);
        if(friendsList.size() == 0){
            throw new NoFriendListException(userId + "未和任何人是好友关系");
        }
        return friendsList;
    }
}
