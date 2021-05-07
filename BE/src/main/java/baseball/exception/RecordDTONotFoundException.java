package baseball.exception;

public class RecordDTONotFoundException extends NotFoundException {

    private static final String MESSAGE = "record가 존재하지 않습니다.";

    public RecordDTONotFoundException() {
        super(MESSAGE);
    }
}
