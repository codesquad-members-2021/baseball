package com.baseball.repository;

import com.baseball.domain.match.Match;

import java.util.Map;

public interface BaseballRepository {
    Map<String, Match> findAllMatches();

    Match findMatchById(String id);
}
