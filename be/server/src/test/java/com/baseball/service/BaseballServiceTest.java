package com.baseball.service;

import com.baseball.exception.MatchOccupiedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    @DisplayName("한번 선택한 팀을 바꾸려 하면 예외 발생")
    void selectTeamAgain() {
        String matchId = "MATCH_ID";
        String teamName = "HOME";
        baseballService.selectTeam(matchId, teamName);
        assertThatExceptionOfType(MatchOccupiedException.class)
                .isThrownBy(() -> baseballService.selectTeam(matchId, "AWAY"))
                .withMessage("다른 사람이 선점한 경우에는 게임에 참가할 수 없습니다.");
    }
}
