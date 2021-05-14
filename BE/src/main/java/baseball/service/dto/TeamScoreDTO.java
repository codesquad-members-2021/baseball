package baseball.service.dto;

import baseball.domain.Score;
import baseball.domain.Team;

import java.util.Set;

public class TeamScoreDTO {

    private Long teamId;
    private String teamName;
    private Set<Score> scores;

    public TeamScoreDTO(Team team) {
        this.teamId = team.getId();
        this.teamName = team.getName();
        this.scores = team.getScores();
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
