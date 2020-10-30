package cn.yesomething.domain;

import java.util.Arrays;
import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userSex;

    private String userNickname;

    private Date userBirthday;

    private String userPicture;

    private String[] userHistoricalPictures;

    private String userEmail;

    private String userPhoneNumber;

    private String[] userTags;

    private String bubbleType;

    private String[] historicalBubbleTypes;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(Integer userId, String userName, String userPassword, Integer userSex, String userNickname, Date userBirthday, String userPicture, String[] userHistoricalPictures, String userEmail, String userPhoneNumber, String[] userTags, String bubbleType, String[] historicalBubbleTypes) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userNickname = userNickname;
        this.userBirthday = userBirthday;
        this.userPicture = userPicture;
        this.userHistoricalPictures = userHistoricalPictures;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userTags = userTags;
        this.bubbleType = bubbleType;
        this.historicalBubbleTypes = historicalBubbleTypes;
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
                ", userHistoricalPictures=" + Arrays.toString(userHistoricalPictures) +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userTags=" + Arrays.toString(userTags) +
                ", bubbleType='" + bubbleType + '\'' +
                ", historicalBubbleTypes=" + Arrays.toString(historicalBubbleTypes) +
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
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
        this.userNickname = userNickname;
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
        this.userPicture = userPicture;
    }

    public String[] getUserHistoricalPictures() {
        return userHistoricalPictures;
    }

    public void setUserHistoricalPictures(String[] userHistoricalPictures) {
        this.userHistoricalPictures = userHistoricalPictures;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String[] getUserTags() {
        return userTags;
    }

    public void setUserTags(String[] userTags) {
        this.userTags = userTags;
    }

    public String getBubbleType() {
        return bubbleType;
    }

    public void setBubbleType(String bubbleType) {
        this.bubbleType = bubbleType;
    }

    public String[] getHistoricalBubbleTypes() {
        return historicalBubbleTypes;
    }

    public void setHistoricalBubbleTypes(String[] historicalBubbleTypes) {
        this.historicalBubbleTypes = historicalBubbleTypes;
    }
}