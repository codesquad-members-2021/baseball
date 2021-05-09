package com.baseball.repository;

import com.baseball.domain.Match;

import java.util.Map;

public interface BaseballRepository {
    Map<String, Match> findAllMatches();
}
