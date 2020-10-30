package cn.yesomething.Exception;

public class PictureDecodeException extends RuntimeException{
    private String message;

    public PictureDecodeException(String message) {
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

