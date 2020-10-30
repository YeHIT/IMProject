package cn.yesomething.Exception;

public class UnknownException extends RuntimeException{
    private String message;

    public UnknownException(String message) {
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