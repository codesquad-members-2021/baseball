package com.baseball.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballServiceTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private SoftAssertions softly;

    private BaseballService baseballService;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
        baseballService = new BaseballService();
    }

    @Test
    @DisplayName("참가가능한 게임 목록이 정상적으로 반환되는지 스냅샷 테스트")
    void getMatches() throws JsonProcessingException {
        String actual = objectMapper.writeValueAsString(baseballService.getMatches());
        String expected = "[{\"home\":\"HOME\",\"away\":\"AWAY\",\"id\":\"MATCH_ID\"},{\"home\":\"Captain\",\"away\":\"Marble\",\"id\":\"U924AX\"},{\"home\":\"Honux\",\"away\":\"Crong\",\"id\":\"H132UY\"},{\"home\":\"Android\",\"away\":\"Apple\",\"id\":\"M887UW\"}]";
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("홈팀의 아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트")
    void scenario_test_home_0() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "HOME";
        baseballService.selectTeam(matchId, teamName);
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":0,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":false},\"pitcher\":{\"name\":\"HOME1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},\"batter\":{\"name\":\"AWAY1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"AWAY1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},{\"name\":\"AWAY2투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"AWAY1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},{\"name\":\"AWAY2타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"HOME1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},{\"name\":\"HOME2투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"HOME1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},{\"name\":\"HOME2타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("어웨이팀의 아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트")
    void scenario_test_away_0() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "AWAY";
        baseballService.selectTeam(matchId, teamName);
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":0,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":true},\"pitcher\":{\"name\":\"HOME1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},\"batter\":{\"name\":\"AWAY1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"AWAY1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},{\"name\":\"AWAY2투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"AWAY1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},{\"name\":\"AWAY2타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"HOME1투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0},{\"name\":\"HOME2투수\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"HOME1타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},{\"name\":\"HOME2타자\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }


    @Test
    @DisplayName("홈팀의 첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_home_1_ball() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "HOME";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "ball");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":1,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":false},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":1,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[false]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":1,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("어웨이의 첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_away_1_ball() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "AWAY";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "ball");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":1,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":true},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":1,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[false]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":1,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("홈팀의 첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_home_1_hit() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "HOME";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "hit");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":0,\"outCount\":0,\"bases\":[true,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":false},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":1,\"baseOnBalls\":0,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":1,\"out\":0,\"average\":1.0},\"pitcherInfo\":[]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":1,\"baseOnBalls\":0,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":1,\"out\":0,\"average\":1.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("어웨이팀의 첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_away_1_hit() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "AWAY";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "hit");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":0,\"ball\":0,\"outCount\":0,\"bases\":[true,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":true},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":1,\"baseOnBalls\":0,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":1,\"out\":0,\"average\":1.0},\"pitcherInfo\":[]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":1,\"baseOnBalls\":0,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":1,\"out\":0,\"average\":1.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("홈팀의 첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_1_strike() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "HOME";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "strike");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":1,\"ball\":0,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":false},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":0,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[true]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":0,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("어웨이팀의 첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_away_1_strike() throws JsonProcessingException {
        String matchId = "MATCH_ID";
        String teamName = "AWAY";
        baseballService.selectTeam(matchId, teamName);
        baseballService.playGame(matchId, "strike");

        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(matchId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(matchId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"strike\":1,\"ball\":0,\"outCount\":0,\"bases\":[false,false,false],\"inningInfo\":{\"inningCount\":1,\"userTop\":true,\"userOffense\":true},\"pitcher\":{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":0,\"innings\":1},\"batter\":{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0},\"pitcherInfo\":[true]}";
        String expectedGameInfo = "{\"scores\":{\"awayScore\":0,\"homeScore\":0},\"innings\":{\"away\":[],\"home\":[]},\"awayPlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":1,\"hit\":0,\"baseOnBalls\":0,\"innings\":1}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":0,\"hit\":0,\"out\":0,\"average\":0.0}]},\"homePlayers\":{\"pitchers\":[{\"name\":\"김광현\",\"numberOfPitching\":0,\"hit\":0,\"baseOnBalls\":0,\"innings\":0}],\"batters\":[{\"name\":\"류현진\",\"plateAppearances\":1,\"hit\":0,\"out\":0,\"average\":0.0}]}}";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    // 공수가 바뀌는 상황 (아웃이 3번이 나는 상황)
    // 이닝이 바뀌는 상황 (공수가 바뀌면 이닝이 변함 예) 홈팀 기준으로 수비 -> 공격 이닝 1끝 이닝 2시작
}
