package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class TeamScores {

    private Integer totalScore;

    @MappedCollection(idColumn = "information_id", keyColumn = "inning")
    private List<InningScore> inningScore;

    TeamScores(Integer totalScore, List<InningScore> inningScore) {
        this.totalScore = totalScore;
        this.inningScore = inningScore;
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
