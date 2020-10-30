package cn.yesomething.Exception;
//无此用户
public class NoFriendRelationException extends RuntimeException{
    private String message;

    public NoFriendRelationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
