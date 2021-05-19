package com.team22.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "TEAM_SCORE")
public class TeamScore {

    @Id
    @JsonIgnore
    private final Long id;

    @JsonIgnore
    private final Long teamId;

    private final int round;

    private final int score;

    @PersistenceConstructor
    private TeamScore(Long id, Long teamId, int round, int score) {
        this.id = id;
        this.teamId = teamId;
        this.round = round;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public int getRound() {
        return round;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "TeamScore{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", round=" + round +
                ", score=" + score +
                '}';
    }
}
