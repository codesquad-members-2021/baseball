package com.baseball.repository;

import com.baseball.domain.*;

import java.util.Arrays;

public class MockedGameInfoRepository implements GameInfoRepository {

    private final GameInfo gameinfo;

    public MockedGameInfoRepository() {
        Score score = new Score(3, 2);
        Innings innings = new Innings(Arrays.asList(1, 1, 1), Arrays.asList(1, 1));

        Players awayPlayers = new Players(
                Arrays.asList(new Pitcher("김광현", 6, 1, 0, 2)),
                Arrays.asList(new Batter("류현진", 2, 1, 1, 0.500F))
        );

        Players homePlayers = new Players(
                Arrays.asList(new Pitcher("김광현", 6, 1, 0, 2)),
                Arrays.asList(new Batter("류현진", 2, 1, 1, 0.500F))
        );

        gameinfo = new GameInfo(score, innings, awayPlayers, homePlayers);
    }

    @Override
    public GameInfo findByGameId(String id) {
        return gameinfo;
    }
}
