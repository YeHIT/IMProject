package cn.yesomething.Exception;
//用户名或密码为空
public class UserNameIsNullException extends RuntimeException{
    private String message;

    public UserNameIsNullException(String message) {
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
