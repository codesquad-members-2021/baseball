package com.baseball.domain.team;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.baseball.domain.team.TeamFactory.createTeam;


class TeamsTest {
    private Teams teams;
    private SoftAssertions softly;

    @BeforeEach
    void setUp() {
        teams = new Teams(
                createTeam("AWAY"),
                createTeam("HOME")
        );
        softly = new SoftAssertions();
    }

    @Test
    @DisplayName("공수가 바뀌면, 공격팀에는 새로운 점수판이 생기고, 수비팀은 투수가 바뀌어야 한다.")
    void switchRole() {
        softly.assertThat(teams.getHomeTeam().getScores())
                .isEqualTo(new ArrayList<>());
        softly.assertThat(teams.getAwayTeam().getPitcher().getName())
                .isEqualTo("AWAY1투수");

        teams.switchRole();
        softly.assertThat(teams.getHomeTeam().getScores())
                .isEqualTo(Arrays.asList(0));
        softly.assertThat(teams.getAwayTeam().getPitcher()
                .getName()).isEqualTo("AWAY2투수");
        softly.assertAll();
    }

    @Test
    @DisplayName("proceedToNextBase 를 하면 타자가 바뀐다.")
    void proceedToNextBase_changeBatter() {
        softly.assertThat(teams.getAwayTeam().getBatter().getName())
                .isEqualTo("AWAY1타자");

        teams.proceedToNextBase(Boolean.FALSE);
        softly.assertThat(teams.getAwayTeam().getBatter().getName())
                .isEqualTo("AWAY2타자");
        softly.assertAll();
    }

    @Test
    @DisplayName("삼루가 true 일 경우에만, proceedToNextBase 를 했을 때 점수가 증가해야한다.")
    void proceedToNextBase_fullBase() {
        softly.assertThat(teams.getAwayTeam().getScores())
                .isEqualTo(Arrays.asList(0));

        teams.proceedToNextBase(Boolean.TRUE);
        softly.assertThat(teams.getAwayTeam().getScores())
                .isEqualTo(Arrays.asList(1));
        softly.assertAll();
    }
}
