package com.baseball.repository;

import com.baseball.domain.Match;
import com.baseball.domain.Matches;
import com.baseball.domain.Team;
import com.baseball.domain.player.Players;

import java.util.Arrays;
import java.util.Map;

public class MockedBaseballRepository implements BaseballRepository {
    private final Matches matches = new Matches();

    public MockedBaseballRepository() {
        matches.put("U924AX", new Match(
                new Team("Captain", new Players(Arrays.asList(), Arrays.asList())),
                new Team("Marble", new Players(Arrays.asList(), Arrays.asList()))
        ));
        matches.put("H132UY", new Match(
                new Team("Honux", new Players(Arrays.asList(), Arrays.asList())),
                new Team("Crong", new Players(Arrays.asList(), Arrays.asList()))
        ));
        matches.put("M887UW", new Match(
                new Team("Android", new Players(Arrays.asList(), Arrays.asList())),
                new Team("Apple", new Players(Arrays.asList(), Arrays.asList()))
        ));
    }

    @Override
    public Map<String, Match> findAllMatches() {
        return matches.getMatches();
    }
}
