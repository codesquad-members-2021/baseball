package baseball.service.dto;

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
}
