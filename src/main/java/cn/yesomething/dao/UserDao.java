package cn.yesomething.dao;

import cn.yesomething.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int deleteByUserName(String userName);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    String selectPasswordByUserName(String userName);

    User selectByUserName(String userName);

    List<User> selectByUserNickname(String userNickname);

    List<User> selectAll();

    int updateByPrimaryKey(User user);

    int updateByUserNameSelective(User user);
}