package cn.yesomething.service;

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
     * @return 是否添加成功
     */
    @Override
    public int addFriend(Friends friends) {
        Friends resultFriends = selectByEachOther(friends);
        if(resultFriends == null){
            return friendsDao.insertFriends(friends);
        }
        else {        //二者已经是好友了
            return 2;
        }
    }

    /**
     * 更新好友信息
     * @param friends 需要更新的好友信息
     * @return 更新后的好友信息
     */
    @Override
    public Friends updateFriend(Friends friends) {
        int result = friendsDao.updateByEachOther(friends);
        if(result == 1){
            return friendsDao.selectByEachOther(friends);
        }
        return null;
    }

    /**
     * 根据双方名字查询好友信息
     * @param friends 需要查询的好友信息
     * @return 好友信息
     */
    @Override
    public Friends selectByEachOther(Friends friends) {
        return friendsDao.selectByEachOther(friends);
    }

    /**
     * 根据userId查询他的全部好友信息
     *
     * @param userId 需要查询的人
     * @return 全部好友信息
     */
    @Override
    public List<Friends> selectFriendsListByUserId(String userId) {
        return friendsDao.selectFriendsListByUserId(userId);
    }
}
