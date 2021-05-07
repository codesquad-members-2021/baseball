package baseball.exception;

public class TeamNotFoundException extends NotFoundException {

    private static final String MESSAGE = "team이 존재하지 않습니다.";

    public TeamNotFoundException() {
        super(MESSAGE);
    }
}
