package cn.yesomething.domain;

import java.util.Date;

public class Message {
    private Integer messageId;

    private String fromId;

    private String toId;

    private Date messageTime;

    private String messageContent;

    private Integer messageContentType;

    private Double messageEmotionalScore;

    private String processedContent;

    private int hasViolentInfo;

    public Message() {
    }

    public Message(Integer messageId, String fromId, String toId, Date messageTime, String messageContent, Integer messageContentType, Double messageEmotionalScore, String processedContent, int hasViolentInfo) {
        this.messageId = messageId;
        this.fromId = fromId;
        this.toId = toId;
        this.messageTime = messageTime;
        this.messageContent = messageContent;
        this.messageContentType = messageContentType;
        this.messageEmotionalScore = messageEmotionalScore;
        this.processedContent = processedContent;
        this.hasViolentInfo = hasViolentInfo;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", messageTime=" + messageTime +
                ", messageContent='" + messageContent + '\'' +
                ", messageContentType=" + messageContentType +
                ", messageEmotionalScore=" + messageEmotionalScore +
                ", processedContent='" + processedContent + '\'' +
                ", hasViolentInfo=" + hasViolentInfo +
                '}';
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
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
        this.messageContent = messageContent;
    }

    public Integer getMessageContentType() {
        return messageContentType;
    }

    public void setMessageContentType(Integer messageContentType) {
        this.messageContentType = messageContentType;
    }

    public Double getMessageEmotionalScore() {
        return messageEmotionalScore;
    }

    public void setMessageEmotionalScore(Double messageEmotionalScore) {
        this.messageEmotionalScore = messageEmotionalScore;
    }

    public String getProcessedContent() {
        return processedContent;
    }

    public void setProcessedContent(String processedContent) {
        this.processedContent = processedContent;
    }

    public int getHasViolentInfo() {
        return hasViolentInfo;
    }

    public void setHasViolentInfo(int hasViolentInfo) {
        this.hasViolentInfo = hasViolentInfo;
    }
}