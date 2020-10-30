package cn.yesomething.Exception;

public class DateParseException extends RuntimeException{
    private String message;

    public DateParseException(String message) {
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

