package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Score;
import com.codesquad.baseball.domain.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamScoreDTO {

    private Long teamId;

    private String teamName;

    private boolean userSelected;

    private List<Score> scores;

    public static TeamScoreDTO of(Team team) {
        List<Score> scores = team.getScores().stream()
                .sorted(Comparator.comparingInt(Score::getInning))
                .collect(Collectors.toList());

        return new TeamScoreDTO(
                team.getId(),
                team.getName(),
                team.isUserSelected(),
                scores
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
