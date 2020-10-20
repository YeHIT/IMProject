package cn.yesomething.dao;

import cn.yesomething.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int deleteByUserName(String userName);

    int insertSelective(User user);

    int updateByUserNameSelective(User user);

    User selectByUserName(String userName);

    String selectPasswordByUserName(String userName);

    List<User> selectByUserNickname(String userNickname);

    List<User> selectAll();

}