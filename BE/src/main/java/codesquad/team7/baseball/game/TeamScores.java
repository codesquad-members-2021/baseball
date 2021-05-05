package codesquad.team7.baseball.game;

import java.util.ArrayList;
import java.util.List;

public class TeamScores {

    private Integer totalScore;
    private List<Integer> inningScore;

    TeamScores(Integer totalScore, List<Integer> inningScore) {
        this.totalScore = totalScore;
        this.inningScore = inningScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public List<Integer> getInningScore() {
        return inningScore;
    }

    public static TeamScores newTeamScores() {
        return new TeamScores(0, new ArrayList<>());
    }
}
