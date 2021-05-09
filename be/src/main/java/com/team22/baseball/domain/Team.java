package com.team22.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(value = "TEAM")
public class Team {

    @Id
    private final Long id;

    private final String name;

    private final boolean isHome;

    private final boolean selected;

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private List<Player> players = new ArrayList<>();

    @MappedCollection(idColumn = "team_id", keyColumn = "id")
    private List<TeamScore> teamScores = new ArrayList<>();

    @PersistenceConstructor
    private Team(Long id, String name, boolean isHome, boolean selected) {
        this.id = id;
        this.name = name;
        this.isHome = isHome;
        this.selected = selected;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<TeamScore> getTeamScores() {
        return teamScores;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHome() {
        return isHome;
    }

    public boolean isSelected() {
        return selected;
    }

    public static Team of(Long id, String name, boolean isHome, boolean selected) {
        return new Team(id, name, isHome, selected);
    }

}
