package cn.yesomething.Exception;

public class NoEnoughMessageException extends RuntimeException{
    private String message;

    public NoEnoughMessageException(String message) {
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
