package baseball.service.dto;

import baseball.domain.Score;

import java.util.Set;

public class TeamScoreDTO {

    private Long teamId;
    private String teamName;
    private Set<Score> scores;

    public TeamScoreDTO(Long teamId, String teamName, Set<Score> scores) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.scores = scores;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public Set<Score> getScores() {
        return scores;
    }
}
