package baseball.exception;

public class MemberNotFoundException extends NotFoundException {

    private static final String MEMBER_NOT_FOUND = "member가 존재하지 않습니다.";

    public MemberNotFoundException() {
        super(MEMBER_NOT_FOUND);
    }
}
