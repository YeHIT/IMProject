package cn.yesomething.Exception;
//用户已存在
public class UserExistException extends RuntimeException{
    private String message;

    public UserExistException(String message) {
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
