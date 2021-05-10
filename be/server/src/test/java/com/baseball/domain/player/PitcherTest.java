package com.baseball.domain.player;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.match.PlayResult.*;

class PitcherTest {
    private SoftAssertions softly;
    private Pitcher pitcher;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
        pitcher = new Pitcher("Pitcher");
    }

    @Test
    @DisplayName("피쳐가 공을 던지지 않았을 경우에 대한 테스트")
    void scenario_initial() {
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(0);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, STRIKE 일 경우에 대한 테스트")
    void scenario_strike() {
        pitcher.play(STRIKE);
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0F);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(1);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, STRIKE 3번일 경우에 대한 테스트")
    void scenario_strike_3() {
        for (int i = 0; i < 3; i++) {
            pitcher.play(STRIKE);
        }
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0.33333334f);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(3);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, STRIKE 9번일 경우에 대한 테스트")
    void scenario_strike_9() {
        for (int i = 0; i < 9; i++) {
            pitcher.play(STRIKE);

        }
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(1F);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(9);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, BALL 일 경우에 대한 테스트")
    void scenario_ball() {
        pitcher.play(BALL);
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0.25F);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(1);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, 4 BALL 일 경우에 대한 테스트")
    void scenario_ball_4() {
        for (int i = 0; i < 4; i++) {
            pitcher.play(BALL);
        }
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(1F);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(4);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, HIT이벤트가 발생한다 하더라도 data는 달라지는게 없어야한다")
    void scenario_hit() {
        pitcher.play(HIT);
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(0);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(1);
        softly.assertAll();
    }

}
