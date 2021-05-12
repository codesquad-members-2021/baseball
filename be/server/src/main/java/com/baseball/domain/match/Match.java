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

    public void selectTeam(String teamName) {
        if (selectedTeam != NONE) {
            throw new MatchOccupiedException();
        }
        String homeTeamName = teams.getHomeTeam().getName();
        selectedTeam = homeTeamName.equals(teamName) ? HOME : AWAY;
    }

    public Boolean getUserOffense() {
        if (selectedTeam == AWAY) {
            return matchInfo.getUserTop();
        }
        return !matchInfo.getUserTop();
    }

    public void play(String pitch) {
        PlayResult playResult = PlayResult.of(pitch);
        Boolean isThirdBaseTrue = matchInfo.isThirdBaseTrue();
        if (playResult == PlayResult.HIT) {
            teams.proceedToNextBase(isThirdBaseTrue);
            matchInfo.proceedToNextBase();
        }
        teams.play(playResult);
        matchInfo.pushPlayResult(playResult);
        if (matchInfo.getBallCount() >= 4) {
            teams.proceedToNextBase(isThirdBaseTrue);
            matchInfo.proceedToNextBase();
            matchInfo.resetPlayResults();
        }
        if (matchInfo.getOutCount() >= 3) {
            teams.switchRole();
            matchInfo.proceedToNextHalve();
        }
    }
}
