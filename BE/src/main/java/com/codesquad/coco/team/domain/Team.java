package com.codesquad.coco.team.domain;

import com.codesquad.coco.player.domain.Player;
import org.springframework.data.annotation.Id;

import java.util.Set;

public class Team {

    @Id
    private String name;

    private Set<Player> players;

    public Team(String name, Set<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
