package com.baseball.domain.match;

import com.baseball.exception.MatchNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MatchesTest {
    private Matches matches;

    @BeforeEach
    public void setUp() {
        matches = new Matches();
    }

    @Test
    @DisplayName("존재하지 않는 id 의 Match 를 조회하면, MatchNotFoundException 이 발생한다.")
    void getMatch() {
        assertThatExceptionOfType(MatchNotFoundException.class)
                .isThrownBy(() -> matches.getMatch("BAD_ID"))
                .withMessage("존재하지 않는 Match Id 입니다; BAD_ID");
    }
}
