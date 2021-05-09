package com.baseball.domain;

import com.baseball.exception.MatchNotFoundException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Matches {
    private final Map<String, Match> matches = new ConcurrentHashMap<>();

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
