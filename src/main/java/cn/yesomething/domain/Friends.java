package cn.yesomething.domain;

public class Friends {
    private Integer friendsId;

    private String friendId;

    private String userId;

    private String friendName;

    private String friendType;

    private String friendGroupType;

    public Friends() {
    }

    public Friends(String friendId, String userId, String friendName, String friendType, String friendGroupType) {
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
                ", friendId='" + friendId + '\'' +
                ", userId='" + userId + '\'' +
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

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendType() {
        return friendType;
    }

    public void setFriendType(String friendType) {
        this.friendType = friendType;
    }

    public String getFriendGroupType() {
        return friendGroupType;
    }

    public void setFriendGroupType(String friendGroupType) {
        this.friendGroupType = friendGroupType;
    }
}