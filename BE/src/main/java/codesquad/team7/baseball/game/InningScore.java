package codesquad.team7.baseball.game;

public class InningScore {

    private Integer score;

    public InningScore(Integer score) {
        this.score = score;
    }

    public Integer getInningScore() {
        return score;
    }

    public void scoreUp() {
        score++;
    }
}
