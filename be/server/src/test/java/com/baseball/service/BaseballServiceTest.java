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
        String expected = "[{\"home\":\"Captain\",\"away\":\"Marble\",\"id\":\"U924AX\"},{\"home\":\"Honux\",\"away\":\"Crong\",\"id\":\"H132UY\"},{\"home\":\"Android\",\"away\":\"Apple\",\"id\":\"M887UW\"}]";
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("아무것도 하지 않은 첫 이닝에 대한 스냅샷 테스트")
    void scenario_test_0() throws JsonProcessingException {
        String gameId = "TODO";
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(gameId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(gameId));

        String expectedProgress = "TODO";
        String expectedGameInfo = "TODO";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("첫 이닝에서 Ball 이 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_1_ball() throws JsonProcessingException {
        baseballService.playGame("ball");

        String gameId = "TODO";
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(gameId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(gameId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "TODO";
        String expectedGameInfo = "TODO";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("첫 이닝에서 Hit 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_1_hit() throws JsonProcessingException {
        baseballService.playGame("hit");

        String gameId = "TODO";
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(gameId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(gameId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "TODO";
        String expectedGameInfo = "TODO";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }

    @Test
    @DisplayName("첫 이닝에서 Strike 가 나왔을 경우에 대한 스냅샷 테스트")
    void scenario_test_1_strike() throws JsonProcessingException {
        baseballService.playGame("strike");

        String gameId = "TODO";
        String actualProgress = objectMapper.writeValueAsString(baseballService.getProgress(gameId));
        String actualGameInfo = objectMapper.writeValueAsString(baseballService.getGameInfo(gameId));

        //TODO: 스냅샷을 떠야한다.
        String expectedProgress = "TODO";
        String expectedGameInfo = "TODO";

        softly.assertThat(actualProgress)
                .isEqualTo(expectedProgress);
        softly.assertThat(actualGameInfo)
                .isEqualTo(expectedGameInfo);
        softly.assertAll();
    }
}
