package com.team22.baseball.dto.response.DetailScore;

import com.team22.baseball.domain.TeamScore;

import java.util.ArrayList;
import java.util.List;

public class detailScoreDto {

    private String name;

    private List<TeamScore> scores = new ArrayList<>();

    public detailScoreDto(String name, List<TeamScore> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public List<TeamScore> getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(List<TeamScore> scores) {
        this.scores = scores;
    }
}
