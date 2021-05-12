package com.baseball.domain.match;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.match.PlayResult.*;

class PlayResultTest {

    private SoftAssertions softly;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
    }

    @Test
    @DisplayName("String 이 PlayResult 로 잘 변환되는지 테스트 (HIT, STRIKE, BALL, 랜덤)")
    void of() {
        softly.assertThat(PlayResult.of("HIT")).isEqualTo(HIT);
        softly.assertThat(PlayResult.of("STRIKE")).isEqualTo(STRIKE);
        softly.assertThat(PlayResult.of("BALL")).isEqualTo(BALL);
        softly.assertThat(PlayResult.of("랜덤")).isIn(HIT, STRIKE, BALL);
        softly.assertAll();
    }

    @Test
    @DisplayName("PlayResult 가 Boolean 으로 잘 변환되는지 테스트 (STRIKE 만 true 이다)")
    void toBoolean() {
        softly.assertThat(PlayResult.of("STRIKE").toBoolean()).isEqualTo(Boolean.TRUE);
        softly.assertThat(PlayResult.of("BALL").toBoolean()).isEqualTo(Boolean.FALSE);
        softly.assertAll();

    }
}
