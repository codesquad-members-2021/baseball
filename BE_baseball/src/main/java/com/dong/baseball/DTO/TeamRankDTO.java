package com.dong.baseball.DTO;

import com.dong.baseball.Domain.Team;

public class TeamRankDTO {
    private Long teamId;
    private String teamName;
    private int win;
    private int lose;
    private int draw;
    private int victoryPoint;

    public TeamRankDTO(Team team) {
        this.teamId = team.getTeamId();
        this.teamName = team.getTeamName();
        this.win = team.getWin();
        this.lose = team.getLose();
        this.draw = team.getDraw();
        this.victoryPoint = team.getVictoryPoint();
    }

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

    @Override
    public String toString() {
        return "TeamRankDTO{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", win=" + win +
                ", lose=" + lose +
                ", draw=" + draw +
                ", victoryPoint=" + victoryPoint +
                '}';
    }
}
