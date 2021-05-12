package codesquad.team7.baseball.game;

public class HomeInningScore {

    private Integer score;

    public HomeInningScore(Integer score) {
        this.score = score;
    }

    public Integer getInningScore() {
        return score;
    }

    public void scoreUp() {
        score++;
    }
}
