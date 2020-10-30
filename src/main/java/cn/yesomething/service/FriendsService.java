package cn.yesomething.service;

import cn.yesomething.domain.Friends;

import java.util.List;

//好友相关服务
public interface FriendsService {
    /**
     * 添加好友
     * @param friends 需要添加的好友关系
     */
    void addFriend(Friends friends);

    /**
     * 更新好友信息
     * @param friends 需要更新的好友信息
     * @return 更新后的好友信息
     */
    Friends updateFriend(Friends friends);

    /**
     * 根据双方名字查询好友信息
     * @param friends 需要查询的好友信息
     * @return 好友信息
     */
    Friends selectByEachOther(Friends friends);

    /**
     * 根据userId查询他的全部好友信息
     * @param userId 需要查询的人
     * @return 全部好友信息
     */
    List<Friends> selectFriendsListByUserId(String userId);
}
