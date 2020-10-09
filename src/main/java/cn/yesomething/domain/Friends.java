package cn.yesomething.domain;

public class Friends {
    private Integer friendsId;

    private Integer friendId;

    private Integer userId;

    private String friendName;

    private Integer friendType;

    private Integer friendGroupType;

    public Friends() {
    }

    public Friends(Integer friendId, Integer userId, String friendName,
                   Integer friendType, Integer friendGroupType) {
        this.friendId = friendId;
        this.userId = userId;
        this.friendName = friendName;
        this.friendType = friendType;
        this.friendGroupType = friendGroupType;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "friendsId=" + friendsId +
                ", friendId=" + friendId +
                ", userId=" + userId +
                ", friendName='" + friendName + '\'' +
                ", friendType=" + friendType +
                ", friendGroupType=" + friendGroupType +
                '}';
    }

    public Integer getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(Integer friendsId) {
        this.friendsId = friendsId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public Integer getFriendType() {
        return friendType;
    }

    public void setFriendType(Integer friendType) {
        this.friendType = friendType;
    }

    public Integer getFriendGroupType() {
        return friendGroupType;
    }

    public void setFriendGroupType(Integer friendGroupType) {
        this.friendGroupType = friendGroupType;
    }
}