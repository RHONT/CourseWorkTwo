package ru.rhontcompany.aqapi.exception;

public class StopedMathRepository extends RuntimeException{
    public StopedMathRepository() {
    }

    public StopedMathRepository(String message) {
        super(message);
    }

    public StopedMathRepository(String message, Throwable cause) {
        super(message, cause);
    }

    public StopedMathRepository(Throwable cause) {
        super(cause);
    }

    public StopedMathRepository(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
