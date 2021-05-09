package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Player;
import com.codesquad.baseball.domain.Team;

import java.util.Set;

public class TeamDTO {

    private Long id;

    private String teamName;

    private Set<Player> players;

    private TeamDTO(Long id, String name, Set<Player> players) {
        this.id = id;
        this.teamName = name;
        this.players = players;
    }

    public static TeamDTO of(Team team) {
        return new TeamDTO(team.getId(), team.getName(), team.getPlayers());
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
