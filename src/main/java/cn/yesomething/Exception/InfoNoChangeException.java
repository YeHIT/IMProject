package cn.yesomething.Exception;
//无此用户
public class InfoNoChangeException extends RuntimeException{
    private String message;

    public InfoNoChangeException(String message) {
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
