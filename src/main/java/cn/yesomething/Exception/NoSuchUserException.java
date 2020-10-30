package cn.yesomething.Exception;
//无此用户
public class NoSuchUserException extends RuntimeException{
    private String message;

    public NoSuchUserException(String message) {
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
