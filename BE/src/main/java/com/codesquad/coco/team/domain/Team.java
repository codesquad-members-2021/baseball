package com.codesquad.coco.team.domain;

import com.codesquad.coco.player.domain.Player;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Team {

    @Id
    private String name;

    private List<Player> players;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
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
