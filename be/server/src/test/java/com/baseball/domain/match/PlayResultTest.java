package com.baseball.domain.match;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayResultTest {

    @Test
    @DisplayName("String 이 PlayResult 로 잘 변환되는지 테스트 (HIT, STRIKE, BALL, 랜덤)")
    void of() {
        // TODO:
        PlayResult.of("");
    }

    @Test
    @DisplayName("PlayResult 가 Boolean 으로 잘 변환되는지 테스트 (STRIKE 만 true 이다)")
    void toBoolean() {
        // TODO:
    }
}
