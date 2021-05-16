package baseball.exception;

public class GameNotFoundException extends NotFoundException {

    private static final String GAME_NOT_FOUND = "game이 존재하지 않습니다.";

    public GameNotFoundException() {
        super(GAME_NOT_FOUND);
    }
}
