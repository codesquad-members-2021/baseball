package codesquad.baseball.exception;

public class MatchNotFoundException extends ElementNotFoundException {
    public MatchNotFoundException() {
        super("해당 아이디의 게임을 찾을 수 없습니다.");
    }
}
