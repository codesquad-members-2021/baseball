package com.team22.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(value = "PLAYER")
public class Player {

    // TODO. 추후 PlayerScore 클래스를 만들어서 멤버변수 분리 예정

    @Id
    private final Long id;

    private final String name;

    private final boolean isPitcher;

    private final int uniformNumber;

    private final int plateAppearance;

    private final int hits;

    private final int outs;

    private final int teamId;

    @MappedCollection(idColumn = "player_id", keyColumn = "id")
    private List<PlayerHistory> playerHistories = new ArrayList<>();

    @PersistenceConstructor
    private Player(Long id, String name, boolean isPitcher, int uniformNumber, int plateAppearance, int hits, int outs, int teamId) {
        this.id = id;
        this.name = name;
        this.isPitcher = isPitcher;
        this.uniformNumber = uniformNumber;
        this.plateAppearance = plateAppearance;
        this.hits = hits;
        this.outs = outs;
        this.teamId = teamId;
    }

    public List<PlayerHistory> getPlayerHistories() {
        return playerHistories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPitcher() {
        return isPitcher;
    }

    public int getUniformNumber() {
        return uniformNumber;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public int getHits() {
        return hits;
    }

    public int getOuts() {
        return outs;
    }

    public int getTeamId() {
        return teamId;
    }

    public Player of(String name, boolean isPitcher, int uniformNumber, int plateAppearance, int hits, int outs, int teamId) {
        return new Player(null, name, isPitcher, uniformNumber, plateAppearance, hits, outs, teamId);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPitcher=" + isPitcher +
                ", uniformNumber=" + uniformNumber +
                ", plateAppearance=" + plateAppearance +
                ", hits=" + hits +
                ", outs=" + outs +
                ", teamId=" + teamId +
                ", playerHistories=" + playerHistories +
                '}';
    }
}
