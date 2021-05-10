package com.baseball.domain.player;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.match.PitchResult.BALL;
import static com.baseball.domain.match.PitchResult.STRIKE;

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
                .isEqualTo(1);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(1);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐가 공을 던지고, BALL 일 경우에 대한 테스트")
    void scenario_ball() {
        pitcher.play(BALL);
        softly.assertThat(pitcher.getBaseOnBalls())
                .isEqualTo(0);
        softly.assertThat(pitcher.getInnings())
                .isEqualTo(1);
        softly.assertThat(pitcher.getHit())
                .isEqualTo(0);
        softly.assertThat(pitcher.getNumberOfPitching())
                .isEqualTo(1);
        softly.assertAll();
    }


}
