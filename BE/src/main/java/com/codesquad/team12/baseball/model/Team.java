package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.PlayerDto;
import com.codesquad.team12.baseball.dto.TeamDto;
import com.codesquad.team12.baseball.dto.TeamPlayerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                .map(Player::createPlayerDto)
                .collect(Collectors.toList());

        return new TeamPlayerDto(team.name, playerDtos);
    }

}
