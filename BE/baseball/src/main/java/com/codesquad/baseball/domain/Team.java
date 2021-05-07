package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class Team {

    @Id
    private Long id;

    private String name;

    private boolean isHome;

    private boolean isPlayable;

    private Long pitcherId;

    public Team(String name, boolean isHome, boolean isPlayable) {
        this.name = name;
        this.isHome = isHome;
        this.isPlayable = isPlayable;
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

    public boolean isPlayable() {
        return isPlayable;
    }

    public Long getPitcherId() {
        return pitcherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public void setPitcherId(Long pitcherId) {
        this.pitcherId = pitcherId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
