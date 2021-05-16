package baseball.exception;

public class TeamNotFoundException extends NotFoundException {

    private static final String TEAM_NOT_FOUND = "team이 존재하지 않습니다.";

    public TeamNotFoundException() {
        super(TEAM_NOT_FOUND);
    }
}
