package com.team22.baseball.dto.response.DetailScore;

import com.team22.baseball.domain.TeamScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailScore {

    private String name;

    private List<TeamScore> scores = new ArrayList<>();

    public DetailScore(String name, List<TeamScore> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {

        //INFO. SCORES 는 라운드 정보를 포함하고 있는 동적 객체여서 그대로 보낼 수도 있지만, 프론트단에서 동적으로 파싱하기 불편하여 12 사이즈의 배열로 변환함

        int[] arrayScore = new int[10];
        Arrays.fill(arrayScore, -1); // 점수가 없는건 -1

        for (int i = 0; i < scores.size(); i++) {
            arrayScore[i] = scores.get(i).getScore();
        }

        return arrayScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(List<TeamScore> scores) {
        this.scores = scores;
    }
}
