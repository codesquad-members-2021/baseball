package com.codesquad.coco.team.domain.DTO;

public class TeamPointDTO {

    private String teamName;
    private int round;
    private int point;

    public String getTeamName() {
        return teamName;
    }

    public int getRound() {
        return round;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "TeamPointDTO{" +
                "teamName='" + teamName + '\'' +
                ", round=" + round +
                ", point=" + point +
                '}';
    }
}
