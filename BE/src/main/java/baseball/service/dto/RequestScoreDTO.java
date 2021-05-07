package baseball.service.dto;

public class RequestScoreDTO {

    private int inningNumber;
    private int score;

    public RequestScoreDTO(int inningNumber, int score) {
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
