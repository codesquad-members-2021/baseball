package com.baseball.domain.match;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.team.Teams;

import static com.baseball.domain.team.SelectedTeam.AWAY;

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
        return teams.getSelectedTeam() == AWAY ? getUserTop() : !getUserTop();
    }

    public void play(String pitch) {
        PitchResult pitchResult = PitchResult.of(pitch);
        Pitcher pitcher = teams.getPitcher();
        Batter batter = teams.getBatter();
        pitcher.play(pitchResult);
        batter.play(pitchResult);
        matchInfo.update(pitchResult);
    }
}
