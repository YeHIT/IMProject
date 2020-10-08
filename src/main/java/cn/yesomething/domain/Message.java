package cn.yesomething.domain;

import java.util.Date;

public class Message {
    Integer message_id;
    Integer from_id;
    Integer to_id;
    Date message_time;
    String message_content;
    Integer message_contenttype;

    public Message() {
    }

    public Message(Integer message_id, Integer from_id, Integer to_id, Date message_time, String message_content, Integer message_contenttype) {
        this.message_id = message_id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.message_time = message_time;
        this.message_content = message_content;
        this.message_contenttype = message_contenttype;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public Date getMessage_time() {
        return message_time;
    }

    public void setMessage_time(Date message_time) {
        this.message_time = message_time;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Integer getMessage_contenttype() {
        return message_contenttype;
    }

    public void setMessage_contenttype(Integer message_contenttype) {
        this.message_contenttype = message_contenttype;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", message_time=" + message_time +
                ", message_content='" + message_content + '\'' +
                ", message_contenttype=" + message_contenttype +
                '}';
    }
}
