package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class HomeScores {

    private Integer totalScore;

    @MappedCollection(idColumn = "information_id", keyColumn = "inning")
    private final List<HomeInningScore> homeInningScore;

    HomeScores(Integer totalScore, List<HomeInningScore> homeInningScore) {
        this.totalScore = totalScore;
        this.homeInningScore = homeInningScore;
    }

    public void scoreUp(int inning) {
        totalScore++;
        HomeInningScore score = homeInningScore.get(inningIndex(inning));
        score.scoreUp();
    }

    private int inningIndex(int inning) {
        return inning - 1;
    }

    public void nextInning() {
        homeInningScore.add(new HomeInningScore(0));
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public List<HomeInningScore> getInningScore() {
        return homeInningScore;
    }

    public static HomeScores newTeamScores() {
        return new HomeScores(0, new ArrayList<>());
    }
}
