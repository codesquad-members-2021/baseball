package com.baseball.domain.team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.baseball.domain.match.PlayResult.HIT;
import static com.baseball.domain.match.PlayResult.STRIKE;
import static com.baseball.domain.team.TeamFactory.createTeam;
import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {
    private Team team;

    @BeforeEach
    void setUp() {
        team = createTeam("TEAM");
    }

    @Test
    @DisplayName("pushScore 를 하면, 팀에 값이 0인 점수판이 추가되어야 한다.")
    void pushScore() {
        team.pushScore();
        assertThat(team.getScores()).isEqualTo(Arrays.asList(0));

    }

    @Test
    @DisplayName("increaseScore 를 하면, 팀의 마지막 점수판이 증가되어야 한다.")
    void increaseScore() {
        team.pushScore();
        team.increaseScore();
        assertThat(team.getScores()).isEqualTo(Arrays.asList(1));
    }

    @Test
    @DisplayName("changePitcher 를 하면, 다음 투수로 변경되어야 한다.")
    void changePitcher() {
        assertThat(team.getPitcher().getName()).isEqualTo("TEAM1투수");

        team.changePitcher();
        assertThat(team.getPitcher().getName()).isEqualTo("TEAM2투수");

    }

    @Test
    @DisplayName("playOffense 를 하면, HIT 일 경우 다음 타자로 변경되어야 한다.")
    void playOffense() {
        assertThat(team.getBatter().getName()).isEqualTo("TEAM1타자");

        team.playOffense(HIT);
        assertThat(team.getBatter().getName()).isEqualTo("TEAM2타자");
    }

    @Test
    @DisplayName("playDefense 를 하면, 투수가 play 를 한 것과 동일한 효과가 나타나야 한다.")
    void playDefense() {
        team.playDefense(STRIKE);
        assertThat(team.getPitcher().getNumberOfPitching()).isEqualTo(1);

        team.getPitcher().play(STRIKE);
        assertThat(team.getPitcher().getNumberOfPitching()).isEqualTo(2);
    }
}
