package com.baseball.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Matches {
    private final Map<String, Match> matches = new ConcurrentHashMap<>();

    public void put(String id, Match match) {
        matches.put(id, match);
    }

    public Map<String, Match> getMatches() {
        return matches;
    }
}
