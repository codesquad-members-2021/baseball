package com.baseball.repository;

import com.baseball.domain.InningInfo;
import com.baseball.domain.MatchInfo;
import com.baseball.domain.Score;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;

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

        //홈팀의 아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.FALSE); //1회 초 수비
//        Pitcher pitcher = new Pitcher("김광현", 0, 0, 0, 0);
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F); //타석 +1
//        matchInfo = new MatchInfo(score, 0, 0, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, new ArrayList<>());

        //어웨이팀의 아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.TRUE); //1회 초 공격
//        Pitcher pitcher = new Pitcher("김광현", 0, 0, 0, 0);
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F);  //타석 +1
//        matchInfo = new MatchInfo(score, 0, 0, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, new ArrayList<>());


        //홈팀의 첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.FALSE); //1회 초 수비
//        Pitcher pitcher = new Pitcher("김광현", 1, 0, 1, 1); //numberOfPitching +1, ball +1개, innings +1
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F);
//        matchInfo = new MatchInfo(score, 0, 1, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, Arrays.asList(Boolean.FALSE));
        //ball +1, pitcherInfo[false]

        //어웨이팀의 첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.TRUE); //1회 초 공격
//        Pitcher pitcher = new Pitcher("김광현", 1, 0, 1, 1); //numberOfPitching +1, ball +1개, innings +1
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F);
//        matchInfo = new MatchInfo(score, 0, 1, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, Arrays.asList(Boolean.FALSE));
        //ball +1, pitcherInfo[false]

        //홈팀의 첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.FALSE); //1회 초 수비
//        Pitcher pitcher = new Pitcher("김광현", 1, 1, 0, 1); // numberOfPitching +1, hit(피안타) +1, innings +1
//        Batter batter = new Batter("류현진", 1, 1, 0, 1.00F); //타석 +1, 안타 +1, 평균(안타/타석)=1
//        matchInfo = new MatchInfo(score, 0, 0, 0, Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, new ArrayList<>());
        //+1 루(일루 진출)

        //어웨이팀의 첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.TRUE); //1회 초 공격
//        Pitcher pitcher = new Pitcher("김광현", 1, 1, 0, 1);  // numberOfPitching +1, hit(피안타) +1, innings +1
//        Batter batter = new Batter("류현진", 1, 1, 0, 1.00F);  //타석 +1, 안타 +1, 평균(안타/타석)=1
//        matchInfo = new MatchInfo(score, 0, 0, 0, Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, new ArrayList<>());
        //+1 루(일루 진출)

        //홈팀의 첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.FALSE); //1회 초 수비
//        Pitcher pitcher = new Pitcher("김광현", 1, 0, 0, 1);  // numberOfPitching +1, innings +1
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F); //타석 +1
//        matchInfo = new MatchInfo(score, 1, 0, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, Arrays.asList(Boolean.TRUE));
        //pitcherInfo[true]

        //어웨이팀의 첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        InningInfo inningInfo = new InningInfo(1, Boolean.TRUE, Boolean.TRUE); //1회 초 공격
//        Pitcher pitcher = new Pitcher("김광현", 1, 0, 0, 1); // numberOfPitching +1, innings +1
//        Batter batter = new Batter("류현진", 1, 0, 0, 0.00F);  //타석 +1
//        matchInfo = new MatchInfo(score, 1, 0, 0, Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), inningInfo, pitcher, batter, Arrays.asList(Boolean.TRUE));
        //pitcherInfo[true]
    }

    @Override
    public MatchInfo findByGameId(String id) {
        return matchInfo;
    }
}
