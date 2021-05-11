package com.baseball.domain.match;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.baseball.domain.match.PlayResult.*;

class MatchInfoTest {
    private SoftAssertions softly;
    private MatchInfo matchInfo;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
        matchInfo = new MatchInfo();
    }

    @Test
    @DisplayName("첫 경기 시작일 때에 대한 테스트")
    void scenario_initial() {
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(false, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 strike를 던졌을 경우에 대한 테스트")
    void scenario_strike() {
        matchInfo.pushPlayResult(STRIKE);
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(false, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(Arrays.asList(true));
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 strike를 3번 던졌을 경우에 대한 테스트")
    void scenario_strike_3() {
        for (int i = 0; i < 3; i++) {
            matchInfo.pushPlayResult(STRIKE);
        }
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(3);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(false, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(Arrays.asList(true, true, true));
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 strike를 9번 던졌을 경우에 대한 테스트")
    void scenario_strike_9() {
        /**
         * TODO: 논의 필요. 아웃이 3번 되면 MatchInfo 는 초기화 되어야 하지 않을까?
         */
        for (int i = 0; i < 9; i++) {
            matchInfo.pushPlayResult(STRIKE);
        }
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(2);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(9);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(3);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(false, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(Arrays.asList(true, true, true, true, true, true, true, true, true));
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 ball을 던졌을 경우에 대한 테스트")
    void scenario_ball() {
        matchInfo.pushPlayResult(BALL);
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(false, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(Arrays.asList(false));
        softly.assertAll();
    }

    @Test
    @DisplayName("베가 hit을 던졌을 경우에 대한 테스트")
    void scenario_hit() {
        matchInfo.pushPlayResult(HIT);
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("베터가 hit을 연속으로 2번 냈을 경우에 대한 테스트")
    void scenario_hit_2() {
        for (int i = 0; i < 2; i++) {
            matchInfo.pushPlayResult(HIT);
        }
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(true, true, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("베터가 hit을 연속으로 3번 냈을 경우에 대한 테스트")
    void scenario_hit_3() {
        for (int i = 0; i < 3; i++) {
            matchInfo.pushPlayResult(HIT);
        }
        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(true, true, true));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("베터가 strike, ball hit를 차례로 냈을 경우에 대한 테스트")
    void scenario_variety() {
        matchInfo.pushPlayResult(STRIKE);
        matchInfo.pushPlayResult(BALL);
        matchInfo.pushPlayResult(HIT);

        softly.assertThat(matchInfo.getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getStrikeCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getBallCount())
                .isEqualTo(1);
        softly.assertThat(matchInfo.getOutCount())
                .isEqualTo(0);
        softly.assertThat(matchInfo.getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(matchInfo.getPitcherInfo())
                .isEqualTo(Arrays.asList(true, false));
        softly.assertAll();
    }

    @Test
    @DisplayName("공수가 바뀌면, MatchInfo 가 초기화 되어야 한다.")
    void proceedToNextHalve_reset() {
        // TODO:
    }

    @Test
    @DisplayName("공수가 2번 바뀌면, 이닝이 바뀌어야 한다.")
    void proceedToNextHalve_increaseInning() {
        // TODO:
    }
}
