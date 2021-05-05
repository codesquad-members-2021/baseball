package team9.baseball.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("정보를 찾을 수 없습니다.");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
