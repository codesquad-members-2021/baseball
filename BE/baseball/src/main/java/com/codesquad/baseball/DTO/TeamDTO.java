package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamDTO {

    private Long teamId;

    private String teamName;

    private List<PlayerRecordDTO> players;

    private TeamDTO(Long id, String name, List<PlayerRecordDTO> players) {
        this.teamId = id;
        this.teamName = name;
        this.players = players;
    }

    public static TeamDTO of(Team team) {
        List<PlayerRecordDTO> playerRecords = team.getPlayers().stream()
                .map(PlayerRecordDTO::of)
                .sorted(Comparator.comparing(PlayerRecordDTO::getId))
                .collect(Collectors.toList());
        return new TeamDTO(team.getId(), team.getName(), playerRecords);
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<PlayerRecordDTO> getPlayers() {
        return players;
    }
}
