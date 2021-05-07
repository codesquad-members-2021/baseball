package baseball.exception;

public class GameNotFoundException extends NotFoundException {

    private static final String MESSAGE = "game이 존재하지 않습니다.";

    public GameNotFoundException() {
        super(MESSAGE);
    }
}
