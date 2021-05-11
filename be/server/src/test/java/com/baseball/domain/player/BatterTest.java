package com.baseball.domain.player;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.match.PlayResult.*;

class BatterTest {

    private SoftAssertions softly;
    private Batter batter;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
        batter = new Batter("Batter");
    }

    @Test
    @DisplayName("베터가 공을 치지 않았을 경우에 대한 테스트")
    void scenario_initial() {
        softly.assertThat(batter.getPlateAppearances())
                .isEqualTo(0);
        softly.assertThat(batter.getOut())
                .isEqualTo(0);
        softly.assertThat(batter.getAverage())
                .isEqualTo(0);
        softly.assertAll();
    }

    @Test
    @DisplayName("베터에서 hit이 일어났을 경우에 대한 테스트")
    void scenario_hit() {
        batter.increasePlateAppearances();
        batter.play(HIT);
        softly.assertThat(batter.getPlateAppearances())
                .isEqualTo(1);
        softly.assertThat(batter.getOut())
                .isEqualTo(0);
        softly.assertThat(batter.getAverage())
                .isEqualTo(1.0f);
        softly.assertThat(batter.getHit())
                .isEqualTo(1);
        softly.assertAll();
    }

    @Test
    @DisplayName("베터에서 out이 일어났을 경우에 대한 테스트")
    void scenario_out() {
        batter.increasePlateAppearances();
        for (int i = 0; i < 3; i++) {
            batter.play(STRIKE);
        }
        softly.assertThat(batter.getPlateAppearances())
                .isEqualTo(1);
        softly.assertThat(batter.getOut())
                .isEqualTo(1);
        softly.assertThat(batter.getAverage())
                .isEqualTo(0);
        softly.assertThat(batter.getHit())
                .isEqualTo(0);
        softly.assertAll();
    }

    @Test
    @DisplayName("베터에서 out이 3번 일어났을 경우에 대한 테스트")
    void scenario_out_3() {
        batter.increasePlateAppearances();
        for (int i = 0; i < 9; i++) {
            batter.play(STRIKE);
        }
        softly.assertThat(batter.getPlateAppearances())
                .isEqualTo(1);
        softly.assertThat(batter.getOut())
                .isEqualTo(3);
        softly.assertThat(batter.getAverage())
                .isEqualTo(0);
        softly.assertThat(batter.getHit())
                .isEqualTo(0);
        softly.assertAll();
    }

    @Test
    @DisplayName("피쳐에서 ball이 일어났을 경우에 대한 테스트")
    void scenario_ball() {
        batter.increasePlateAppearances();
        batter.play(BALL);
        softly.assertThat(batter.getPlateAppearances())
                .isEqualTo(1);
        softly.assertThat(batter.getOut())
                .isEqualTo(0);
        softly.assertThat(batter.getAverage())
                .isEqualTo(0);
        softly.assertThat(batter.getHit())
                .isEqualTo(0);
        softly.assertAll();
    }
}
