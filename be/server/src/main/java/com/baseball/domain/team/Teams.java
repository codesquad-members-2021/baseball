package com.baseball.domain.team;

import com.baseball.domain.match.PlayResult;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;

import static com.baseball.domain.team.TeamType.AWAY;
import static com.baseball.domain.team.TeamType.HOME;

public class Teams {
    private final Team awayTeam;
    private final Team homeTeam;
    private TeamType offenseTeam = AWAY;

    public Teams(Team awayTeam, Team homeTeam) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void switchRole() {
        offenseTeam = offenseTeam == AWAY ? HOME : AWAY;
        if (offenseTeam == AWAY) {
            awayTeam.pushScore();
        }
        if (offenseTeam == HOME) {
            homeTeam.pushScore();
        }
    }

    public void increaseScore() {
        if (offenseTeam == AWAY) {
            awayTeam.increaseScore();
        }
        if (offenseTeam == HOME) {
            homeTeam.increaseScore();
        }
    }

    public void play(PlayResult playResult) {
        Pitcher pitcher = getPitcher();
        Batter batter = getBatter();
        pitcher.play(playResult);
        batter.play(playResult);
    }

    public Pitcher getPitcher() {
        if (offenseTeam == AWAY) {
            return homeTeam.getPitcher();
        }
        return awayTeam.getPitcher();
    }

    public Batter getBatter() {
        if (offenseTeam == AWAY) {
            return awayTeam.getBatter();
        }
        return homeTeam.getBatter();
    }
}
