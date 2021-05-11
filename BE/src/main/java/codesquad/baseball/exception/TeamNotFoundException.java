package codesquad.baseball.exception;

public class TeamNotFoundException extends ElementNotFoundException {
    public TeamNotFoundException() {
        super("해당 아이디의 팀을 찾을 수 없습니다.");
    }
}
