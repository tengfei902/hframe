package hf.base.exceptions;

public class BizFailException extends RuntimeException {

    public BizFailException() {
    }

    public BizFailException(String message) {
        super(message);
    }

    public BizFailException(String code,String message) {
        super(String.format("%s:%s",code,message));
    }

    public BizFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizFailException(Throwable cause) {
        super(cause);
    }

    public BizFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
