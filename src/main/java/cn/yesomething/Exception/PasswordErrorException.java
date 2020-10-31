package cn.yesomething.Exception;
//密码错误
public class PasswordErrorException extends RuntimeException{
    private String message;

    public PasswordErrorException(String message) {
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
