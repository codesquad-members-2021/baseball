package com.baseball.repository;

import com.baseball.domain.GameInfo;

public interface GameInfoRepository {
    GameInfo findByGameId(String id);
}
