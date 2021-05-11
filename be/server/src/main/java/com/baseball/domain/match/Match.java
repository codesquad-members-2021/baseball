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

    public Boolean getUserOffense() {
        /**
         * NOTE: 만약 유저가 AWAY 팀을 선택했다면, 초반부가 공격이다.
         * 반대로 유저가 HOME 팀을 선택헀다면, 후반부가 공격이다.
         */
        if (selectedTeam == AWAY) {
            return matchInfo.getUserTop();
        }
        return !matchInfo.getUserTop();
    }

    public void play(String pitch) {
        PlayResult playResult = PlayResult.of(pitch);
        matchInfo.update(playResult);
        teams.play(playResult);
    }
}
