package cn.yesomething.domain;

import java.util.Date;

public class User {
    Integer user_id;
    String user_name;
    String user_password;
    Integer user_sex;
    String uesr_nickname;
    Date user_birthday;
    String user_picture;

    public User() {
    }

    public User(Integer user_id, String user_name, String user_password, Integer user_sex, String uesr_nickname, Date user_birthday, String user_picture) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_sex = user_sex;
        this.uesr_nickname = uesr_nickname;
        this.user_birthday = user_birthday;
        this.user_picture = user_picture;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    public String getUesr_nickname() {
        return uesr_nickname;
    }

    public void setUesr_nickname(String uesr_nickname) {
        this.uesr_nickname = uesr_nickname;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_sex=" + user_sex +
                ", uesr_nickname='" + uesr_nickname + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_picture='" + user_picture + '\'' +
                '}';
    }
}
