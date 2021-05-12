package baseball.domain;

import java.util.Objects;

public class Score {

    private int inningNumber;
    private int score;

    public Score(int inningNumber, int score) {
        this.inningNumber = inningNumber;
        this.score = score;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return inningNumber == score1.inningNumber && score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inningNumber, score);
    }
}
