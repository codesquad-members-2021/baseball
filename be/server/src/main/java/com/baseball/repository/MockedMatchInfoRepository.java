package com.baseball.repository;

import com.baseball.domain.Batter;
import com.baseball.domain.MatchInfo;
import com.baseball.domain.Pitcher;
import com.baseball.domain.Score;

import java.util.Arrays;

public class MockedMatchInfoRepository implements MatchInfoRepository {
    private final MatchInfo matchInfo;

    public MockedMatchInfoRepository() {
        Score score = new Score(3, 2);
        Pitcher pitcher = new Pitcher("김광현", 6, 1, 0, 2);
        Batter batter = new Batter("류현진", 2, 1, 1, 0.500F);
        matchInfo = new MatchInfo(score, 2, 3, 1, Arrays.asList(true, true, false), "3회 말 수비", pitcher, batter, Arrays.asList(true, false, false, true, false));
    }

    @Override
    public MatchInfo findByGameId(String id) {
        return matchInfo;
    }
}
