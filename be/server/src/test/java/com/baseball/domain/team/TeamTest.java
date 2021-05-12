package com.baseball.domain.team;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.baseball.domain.match.PlayResult.STRIKE;
import static com.baseball.domain.team.TeamFactory.createTeam;

class TeamTest {
    private Team team;
    private SoftAssertions softly;

    @BeforeEach
    void setUp() {
        team = createTeam("TEAM");
        softly = new SoftAssertions();
    }

    @Test
    @DisplayName("pushScore 를 하면, 팀에 값이 0인 점수판이 추가되어야 한다.")
    void pushScore() {
        team.pushScore();
        softly.assertThat(team.getScores())
                .isEqualTo(Arrays.asList(0));
        softly.assertAll();

    }

    @Test
    @DisplayName("increaseScore 를 하면, 팀의 마지막 점수판이 증가되어야 한다.")
    void increaseScore() {
        team.pushScore();
        team.increaseScore();
        softly.assertThat(team.getScores())
                .isEqualTo(Arrays.asList(1));
        softly.assertAll();
    }

    @Test
    @DisplayName("changePitcher 를 하면, 다음 투수로 변경되어야 한다.")
    void changePitcher() {
        softly.assertThat(team.getPitcher().getName())
                .isEqualTo("TEAM1투수");

        team.changePitcher();
        softly.assertThat(team.getPitcher().getName())
                .isEqualTo("TEAM2투수");
        softly.assertAll();

    }

    @Test
    @DisplayName("playDefense 를 하면, 투수가 play 를 한 것과 동일한 효과가 나타나야 한다.")
    void playDefense() {
        team.playDefense(STRIKE);
        softly.assertThat(team.getPitcher().getNumberOfPitching()).isEqualTo(1);

        team.getPitcher().play(STRIKE);
        softly.assertThat(team.getPitcher().getNumberOfPitching()).isEqualTo(2);
        softly.assertAll();
    }
}
