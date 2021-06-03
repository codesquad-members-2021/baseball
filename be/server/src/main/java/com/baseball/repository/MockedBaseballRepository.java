package com.baseball.repository;

import com.baseball.domain.match.Match;
import com.baseball.domain.match.Matches;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.Teams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockedBaseballRepository implements BaseballRepository {
    private final Matches matches = new Matches();

    @Override
    public Map<String, Match> findAllMatches() {
        return matches.getMatches();
    }

    @Override
    public Match findMatchById(String id) {
        return matches.getMatch(id);
    }

    private List<Pitcher> createPitchers(String teamName, int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Pitcher(String.format("%s%d투수", teamName, i)))
                .collect(Collectors.toList());
    }

    private List<Batter> createBatters(String teamName, int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Batter(String.format("%s%d타자", teamName, i)))
                .collect(Collectors.toList());
    }

    private Team createTeam(String teamName) {
        return new Team(teamName, new Players(
                createPitchers(teamName, 5),
                createBatters(teamName, 9)
        ));
    }

    public MockedBaseballRepository() {
        matches.put("MATCH_ID", new Match(new Teams(
                createTeam("AWAY"),
                createTeam("HOME")
        )));
        matches.put("U924AX", new Match(new Teams(
                createTeam("Marble"),
                createTeam("Captain")
        )));
        matches.put("H132UY", new Match(new Teams(
                createTeam("Crong"),
                createTeam("Honux")
        )));
        matches.put("M887UW", new Match(new Teams(
                createTeam("Apple"),
                createTeam("Android")
        )));
    }
}
