package com.baseball.repository;

import com.baseball.domain.MatchInfo;

public interface MatchInfoRepository {
    MatchInfo findByGameId(String id);
}
