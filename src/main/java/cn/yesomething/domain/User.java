package cn.yesomething.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userSex;

    private String userNickname;

    private Date userBirthday;

    private String userPicture;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword,
                Integer userSex, String userNickname, Date userBirthday, String userPicture) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userNickname = userNickname;
        this.userBirthday = userBirthday;
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userNickname='" + userNickname + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPicture='" + userPicture + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }
}