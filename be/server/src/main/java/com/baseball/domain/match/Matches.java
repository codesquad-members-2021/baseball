package com.baseball.domain.match;

import com.baseball.exception.MatchNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Matches {
    private final Map<String, Match> matches = new LinkedHashMap<>();

    public void put(String id, Match match) {
        matches.put(id, match);
    }

    public Map<String, Match> getMatches() {
        return matches;
    }

    public Match getMatch(String id) {
        return Optional.ofNullable(matches.get(id))
                .orElseThrow(() -> new MatchNotFoundException(id));
    }
}
