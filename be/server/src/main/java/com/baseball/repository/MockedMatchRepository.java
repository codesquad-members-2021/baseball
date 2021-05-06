package com.baseball.repository;

import com.baseball.domain.Match;

import java.util.ArrayList;
import java.util.List;

public class MockedMatchRepository implements MatchRepository {
    private static final List<Match> matches = new ArrayList<>();

    static {
        matches.add(new Match("Captain", "Marble", "U924AX"));
        matches.add(new Match("Honux", "Crong", "H132UY"));
        matches.add(new Match("Android", "Apple", "M887UW"));
    }

    @Override
    public List<Match> findAll() {
        return matches;
    }
}
