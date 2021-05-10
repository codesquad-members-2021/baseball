package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.TeamDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class Team {
    @Id
    private String name;

    private boolean isPlaying;

    @MappedCollection(keyColumn = "id")
    private Map<Long, Player> players = new HashMap<>();

    public Team(String name, boolean isPlaying) {
        this.name = name;
        this.isPlaying = isPlaying;
    }

    public static TeamDto of(Team team) {
        return new TeamDto(team.name, team.isPlaying);
    }
}
