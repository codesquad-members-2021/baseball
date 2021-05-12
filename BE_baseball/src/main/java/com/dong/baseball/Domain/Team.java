package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

//    Tigers, Bears, Twins, Dinos, Lions, Eagles, Giants
public class Team {
    @MappedCollection(idColumn = "team_id", keyColumn = "player_index")
    List<Player> members = new ArrayList<>();
    @Id
    private Long teamId;
    private String teamName;
    private int win;
    private int lose;
    private int draw;
    private int victoryPoint;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getVictoryPoint() {
        return victoryPoint;
    }

    public void setVictoryPoint(int victoryPoint) {
        this.victoryPoint = victoryPoint;
    }

    public List<Player> getMembers() {
        return members;
    }
}
