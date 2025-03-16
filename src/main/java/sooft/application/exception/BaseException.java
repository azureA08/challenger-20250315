package sooft.application.exception;

public class BaseException extends Exception {

    private int statusCode;
    private String errorCode;

    public BaseException(String message, int statusCode, String errorCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}