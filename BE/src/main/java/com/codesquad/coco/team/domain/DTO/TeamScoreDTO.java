package com.codesquad.coco.team.domain.DTO;

import java.util.List;

public class TeamScoreDTO {
    private String teamName;
    private List<Integer> point;

    public TeamScoreDTO(String teamName, List<Integer> point) {
        this.teamName = teamName;
        this.point = point;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Integer> getPoint() {
        return point;
    }
}
