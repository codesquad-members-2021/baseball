package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class TeamScores {

    private Integer totalScore;

    @MappedCollection(idColumn = "information_id", keyColumn = "inning")
    private final List<InningScore> inningScore;

    TeamScores(Integer totalScore, List<InningScore> inningScore) {
        this.totalScore = totalScore;
        this.inningScore = inningScore;
    }

    public void scoreUp(int inning) {
        totalScore++;
        InningScore score = inningScore.get(inningIndex(inning));
        score.scoreUp();
    }

    private int inningIndex(int inning) {
        return inning - 1;
    }

    public void nextInning() {
        inningScore.add(new InningScore(0));
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public List<InningScore> getInningScore() {
        return inningScore;
    }

    public static TeamScores newTeamScores() {
        return new TeamScores(0, new ArrayList<>());
    }
}
