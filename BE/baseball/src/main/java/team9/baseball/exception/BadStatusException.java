package team9.baseball.exception;

public class BadStatusException extends RuntimeException {
    public BadStatusException() {
        super("객체의 상태가 적절하지 않습니다.");
    }

    public BadStatusException(String message) {
        super(message);
    }

    public BadStatusException(Throwable cause) {
        super(cause);
    }
}
