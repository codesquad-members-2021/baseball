package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.response.PlayerDto;
import com.codesquad.team12.baseball.dto.response.TeamDto;
import com.codesquad.team12.baseball.dto.response.TeamPlayerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.*;
import java.util.stream.Collectors;

public class Team {
    @Id
    private String name;

    private boolean isPlaying;

    @MappedCollection(idColumn = "team_name", keyColumn = "id")
    private Map<Long, Player> players = new HashMap<>();

    public Team(String name, boolean isPlaying) {
        this.name = name;
        this.isPlaying = isPlaying;
    }

    public static TeamDto createTeamDto(Team team) {
        return new TeamDto(team.name, team.isPlaying);
    }

    public static TeamPlayerDto createTeamPlayerDto(Team team) {
        List<PlayerDto> playerDtos = team.players
                .values()
                .stream()
                .sorted(Comparator.comparing(Player::getNumber))
                .map(Player::createPlayerDto)
                .collect(Collectors.toList());

        return new TeamPlayerDto(team.name, playerDtos);
    }

    public String getName() {
        return name;
    }

    public Map<Long, Player> getPlayers() {
        return players;
    }
}
