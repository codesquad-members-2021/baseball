package com.baseball.domain.match;

import com.baseball.domain.team.TeamType;
import com.baseball.domain.team.Teams;
import com.baseball.exception.MatchOccupiedException;

import static com.baseball.domain.team.TeamType.*;

public class Match {
    private final MatchInfo matchInfo = new MatchInfo();
    private final Teams teams;
    private TeamType selectedTeam = NONE;

    public Match(Teams teams) {
        this.teams = teams;
    }

    public Teams getTeams() {
        return teams;
    }

    public MatchInfo getMatchInfo() {
        return matchInfo;
    }

    public TeamType getSelectedTeam() {
        return selectedTeam;
    }

    public void selectTeam(String teamName) {
        if (selectedTeam != NONE) {
            throw new MatchOccupiedException();
        }
        String homeTeamName = teams.getHomeTeam().getName();
        selectedTeam = homeTeamName.equals(teamName) ? HOME : AWAY;
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
        return selectedTeam == AWAY ? getUserTop() : !getUserTop();
    }

    public void play(String pitch) {
        PlayResult playResult = PlayResult.of(pitch);
        matchInfo.update(playResult);
        teams.play(playResult);
    }
}
