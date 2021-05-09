package com.baseball.domain.match;

import com.baseball.domain.team.SelectedTeam;
import com.baseball.domain.team.Teams;

public class Match {
    private final Teams teams;
    private final MatchInfo matchInfo = new MatchInfo();

    public Match(Teams teams) {
        this.teams = teams;
    }

    public Teams getTeams() {
        return teams;
    }

    public MatchInfo getMatchInfo() {
        return matchInfo;
    }

    public void selectTeam(String teamName) {
        teams.selectTeam(teamName);
    }

    public Integer getInningCount() {
        /**
         * NOTE: 한 이닝은 2개의 halves 로 이루어져있다.
         * 출처: https://en.wikipedia.org/wiki/Inning
         */
        return 1 + (matchInfo.getHalvesCount() / 2);
    }

    public Boolean getUserTop() {
        return matchInfo.getHalvesCount() % 2 == 0;
    }

    public Boolean getUserOffense() {
        return getUserTop() && teams.getSelectedTeam() == SelectedTeam.AWAY;
    }
}
