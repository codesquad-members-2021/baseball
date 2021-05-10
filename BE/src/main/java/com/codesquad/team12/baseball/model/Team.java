package com.codesquad.team12.baseball.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class Team {
    @Id
    private Long id;

    private String name;
    private boolean isPlaying;

    @MappedCollection(keyColumn = "id")
    private Map<Long, Player> players = new HashMap<>();

    public Team(Long id, String name, boolean isPlaying) {
        this.id = id;
        this.name = name;
        this.isPlaying = isPlaying;
    }
}
