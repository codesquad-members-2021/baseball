package codesquad.team7.baseball.game;

public class AwayInningScore {
    private Integer score;

    public AwayInningScore(Integer score) {
        this.score = score;
    }

    public Integer getInningScore() {
        return score;
    }

    public void scoreUp() {
        score++;
    }
}
