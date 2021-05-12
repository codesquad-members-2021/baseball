package codesquad.team7.baseball.game;

public enum TeamEnum {
    HOME,
    AWAY;

    public TeamEnum opposite() {
        if (this == HOME) {
            return AWAY;
        }

        return HOME;
    }
}
