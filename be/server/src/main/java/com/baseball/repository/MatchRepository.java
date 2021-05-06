package com.baseball.repository;

import com.baseball.domain.Match;

import java.util.List;

public interface MatchRepository {
    List<Match> findAll();
}
