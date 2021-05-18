package com.codesquad.baseball.DTO.score;

import com.codesquad.baseball.domain.Score;
import com.codesquad.baseball.domain.Team;

import java.util.List;

public class TeamScoreDTO {

    private Long teamId;

    private String teamName;

    private boolean userSelected;

    private List<Score> scores;

    public static TeamScoreDTO of(Team team) {
        return new TeamScoreDTO(
                team.getId(),
                team.getName(),
                team.isUserSelected(),
                team.getSortedScores()
        );
    }

    public TeamScoreDTO(Long teamId, String teamName, boolean userSelected, List<Score> scores) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.userSelected = userSelected;
        this.scores = scores;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean isUserSelected() {
        return userSelected;
    }

    public List<Score> getScores() {
        return scores;
    }
}
