package com.baseball.repository;

import com.baseball.domain.*;

import java.util.Arrays;

public class MockedGameInfoRepository implements GameInfoRepository {

    private final GameInfo gameinfo;

    public MockedGameInfoRepository() {
        //ios와 협의한 기본값
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

        //홈팀 & 어웨이 팀의 아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        Innings innings = new Innings(new ArrayList<>(), new ArrayList<>());
//
//        Players awayPlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 0, 0, 0, 0)),
//                Arrays.asList(new Batter("류현진", 0, 0, 0, 0F))
//        );
//
//        Players homePlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 0, 0, 0, 0)),
//                Arrays.asList(new Batter("류현진", 1, 0, 0, 0F)) //타석 +1
//        );
//
//        gameinfo = new GameInfo(score, innings, awayPlayers, homePlayers);

        //홈팀 & 어웨이 팀의 첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        Innings innings = new Innings(new ArrayList<>(), new ArrayList<>());
//
//        Players awayPlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 1, 0, 1, 1)), //numberOfPitching +1, ball +1개, innings +1
//                Arrays.asList(new Batter("류현진", 0, 0, 0, 0F))
//        );
//
//        Players homePlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 0, 0, 0, 0)),
//                Arrays.asList(new Batter("류현진", 1, 0, 0, 0F))
//        );
//
//        gameinfo = new GameInfo(score, innings, awayPlayers, homePlayers);


        //홈팀 & 어웨이 팀의 첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        Innings innings = new Innings(new ArrayList<>(), new ArrayList<>());
//
//        Players awayPlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 1, 0, 0, 1)),  //numberOfPitching +1, innings +1
//                Arrays.asList(new Batter("류현진", 0, 0, 0, 0F))
//        );
//
//        Players homePlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 0, 0, 0, 0)),
//                Arrays.asList(new Batter("류현진", 1, 1, 0, 0F)) //타석 +1, 안타 +1
//        );
//
//        gameinfo = new GameInfo(score, innings, awayPlayers, homePlayers);

        //홈팀 & 어웨이 팀의 첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트
//        Score score = new Score(0, 0);
//        Innings innings = new Innings(new ArrayList<>(), new ArrayList<>());
//
//        Players awayPlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 1, 0, 0, 1)),  //numberOfPitching +1, innings +1
//                Arrays.asList(new Batter("류현진", 0, 0, 0, 0F))
//        );
//
//        Players homePlayers = new Players(
//                Arrays.asList(new Pitcher("김광현", 0, 0, 0, 0)),
//                Arrays.asList(new Batter("류현진", 1, 0, 0, 0F)) //타석 +1
//        );
//
//        gameinfo = new GameInfo(score, innings, awayPlayers, homePlayers);
    }

    @Override
    public GameInfo findByGameId(String id) {
        return gameinfo;
    }
}
