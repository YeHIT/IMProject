package cn.yesomething.domain;

import java.util.Date;

public class Message {
    private Integer messageId;

    private Integer fromId;

    private Integer toId;

    private Date messageTime;

    private String messageContent;

    private Integer messageContenttype;

    public Message() {
    }

    public Message(Integer messageId, Integer fromId, Integer toId,
                   Date messageTime, String messageContent, Integer messageContenttype) {
        this.messageId = messageId;
        this.fromId = fromId;
        this.toId = toId;
        this.messageTime = messageTime;
        this.messageContent = messageContent;
        this.messageContenttype = messageContenttype;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", messageTime=" + messageTime +
                ", messageContent='" + messageContent + '\'' +
                ", messageContenttype=" + messageContenttype +
                '}';
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Integer getMessageContenttype() {
        return messageContenttype;
    }

    public void setMessageContenttype(Integer messageContenttype) {
        this.messageContenttype = messageContenttype;
    }
}