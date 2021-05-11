package codesquad.team7.baseball.game;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InningTest {

    private SoftAssertions softly;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void afterEach() {
        softly.assertAll();
    }

    @Test
    @DisplayName("새 이닝 객체")
    void newInning() {
        Inning inning = Inning.newInning();

        inning.strike();
        softly.assertThat(inning.getStrike()).isEqualTo(1);
        inning.hit();
        inning.hit();
        inning.hit();
        inning.hit();

        inning.out();
        inning.out();
        inning.out();

    }


}
