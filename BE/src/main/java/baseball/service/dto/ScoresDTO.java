package baseball.service.dto;

import baseball.domain.Score;

import java.util.Set;

public class ScoresDTO {

    private Long teamId;
    private Set<Score> scores;

    public ScoresDTO(Long teamId, Set<Score> scores) {
        this.teamId = teamId;
        this.scores = scores;
    }

    public static ScoresDTO toScoreDTO(Long teamId, Set<Score> scores) {
        return new ScoresDTO(teamId, scores);
    }

    public Long getTeamId() {
        return teamId;
    }

    public Set<Score> getScores() {
        return scores;
    }
}
