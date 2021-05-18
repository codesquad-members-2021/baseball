package team9.baseball.exception;

public class OauthException extends RuntimeException {
    public OauthException() {
        super("Oauth 인증을 할 수 없습니다.");
    }

    public OauthException(String message) {
        super(message);
    }

    public OauthException(Throwable cause) {
        super(cause);
    }
}
