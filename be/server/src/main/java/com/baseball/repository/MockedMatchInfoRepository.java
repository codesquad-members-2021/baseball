package com.baseball.repository;

import com.baseball.domain.*;

import java.util.Arrays;

public class MockedMatchInfoRepository implements MatchInfoRepository {
    private final MatchInfo matchInfo;

    public MockedMatchInfoRepository() {


        //ios와 협의한 기본값
        Score score = new Score(3, 2);
        InningInfo inningInfo = new InningInfo(3, Boolean.TRUE, Boolean.FALSE);
        Pitcher pitcher = new Pitcher("김광현", 6, 1, 0, 2);
        Batter batter = new Batter("류현진", 2, 1, 1, 0.500F);
        matchInfo = new MatchInfo(score, 2, 3, 1, Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE), inningInfo, pitcher, batter, Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));


    }

    @Override
    public MatchInfo findByGameId(String id) {
        return matchInfo;
    }
}
