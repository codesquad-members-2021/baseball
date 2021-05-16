package baseball.service.dto;

import baseball.domain.Score;

public class ScoreRequest {

    private int inningNumber;
    private int score;

    public ScoreRequest(int inningNumber, int score) {
        this.inningNumber = inningNumber;
        this.score = score;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public int getScore() {
        return score;
    }

    public Score toScore() {
        return new Score(inningNumber, score);
    }
}
