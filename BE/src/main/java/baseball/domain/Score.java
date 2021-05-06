package baseball.domain;

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
}
