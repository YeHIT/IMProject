package cn.yesomething.Exception;
//无此用户
public class NoFriendListException extends RuntimeException{
    private String message;

    public NoFriendListException(String message) {
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
