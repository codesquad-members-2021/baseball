package com.baseball.domain.team;

import com.baseball.domain.match.PlayResult;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;

import static com.baseball.domain.team.TeamType.AWAY;
import static com.baseball.domain.team.TeamType.HOME;

public class Teams {
    private final Team awayTeam;
    private final Team homeTeam;
    private TeamType offenseTeamType = AWAY;

    public Teams(Team awayTeam, Team homeTeam) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        awayTeam.getBatter().increasePlateAppearances();
    }

    public void switchRole() {
        offenseTeamType = offenseTeamType == AWAY ? HOME : AWAY;
        offenseTeam().pushScore();
        defenseTeam().changePitcher();
    }

    public void proceedToNextBase(Boolean isBaseFull) {
        offenseTeam().changeBatter();
        if (isBaseFull) {
            offenseTeam().increaseScore();
        }
    }

    public void play(PlayResult playResult) {
        offenseTeam().playOffense(playResult);
        defenseTeam().playDefense(playResult);
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Pitcher getPitcher() {
        return defenseTeam().getPitcher();
    }

    public Batter getBatter() {
        return offenseTeam().getBatter();
    }

    private Team offenseTeam() {
        return offenseTeamType == AWAY ? awayTeam : homeTeam;
    }

    private Team defenseTeam() {
        return offenseTeamType == AWAY ? homeTeam : awayTeam;
    }
}
