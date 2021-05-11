package codesquad.baseball.exception;

public class PlayerNotFoundException extends ElementNotFoundException {
    public PlayerNotFoundException() {
        super("해당 아이디의 플레이어를 찾을 수 없습니다.");
    }
}
