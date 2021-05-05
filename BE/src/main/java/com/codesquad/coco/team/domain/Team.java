package com.codesquad.coco.team.domain;

import com.codesquad.coco.player.domain.Player;
import org.springframework.data.annotation.Id;

import java.util.Set;

public class Team {


    @Id
    private String name;

    private Set<Player> players;

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

}
