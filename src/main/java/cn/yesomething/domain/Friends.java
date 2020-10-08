package cn.yesomething.domain;

public class Friends {
    Integer friends_id;
    Integer friend_id;
    Integer user_id;
    String friend_name;
    Integer friend_type;
    Integer friend_group_type;


    public Friends(){};

    public Friends(Integer friends_id, Integer friend_id, Integer user_id, String friend_name, Integer friend_type, Integer friend_group_type) {
        this.friends_id = friends_id;
        this.friend_id = friend_id;
        this.user_id = user_id;
        this.friend_name = friend_name;
        this.friend_type = friend_type;
        this.friend_group_type = friend_group_type;
    }

    public Integer getFriends_id() {
        return friends_id;
    }

    public void setFriends_id(Integer friends_id) {
        this.friends_id = friends_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public Integer getFriend_type() {
        return friend_type;
    }

    public void setFriend_type(Integer friend_type) {
        this.friend_type = friend_type;
    }

    public Integer getFriend_group_type() {
        return friend_group_type;
    }

    public void setFriend_group_type(Integer friend_group_type) {
        this.friend_group_type = friend_group_type;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "friends_id=" + friends_id +
                ", friend_id=" + friend_id +
                ", user_id=" + user_id +
                ", friend_name='" + friend_name + '\'' +
                ", friend_type=" + friend_type +
                ", friend_group_type=" + friend_group_type +
                '}';
    }
}
