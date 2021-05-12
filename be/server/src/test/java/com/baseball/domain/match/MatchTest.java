package com.baseball.domain.match;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.Teams;
import com.baseball.exception.MatchOccupiedException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MatchTest {
    private Match match;
    private SoftAssertions softly;

    @BeforeEach
    public void setUp() {
        softly = new SoftAssertions();
        match = new Match(new Teams(
                new Team("AWAY", new Players(
                        Arrays.asList(new Pitcher("AWAY1투수"), new Pitcher("AWAY2투수")),
                        Arrays.asList(new Batter("AWAY1타자"), new Batter("AWAY2타자"))
                )),
                new Team("HOME", new Players(
                        Arrays.asList(new Pitcher("HOME1투수"), new Pitcher("HOME2투수")),
                        Arrays.asList(new Batter("HOME1타자"), new Batter("HOME2타자"))
                ))
        ));
    }

    @Test
    @DisplayName("이미 팀이 선택되었다면, 다시 팀을 고를 수 없다.")
    void selectTeam() {
        match.selectTeam("AWAY");
        assertThatExceptionOfType(MatchOccupiedException.class)
                .isThrownBy(() -> match.selectTeam("HOME"))
                .withMessage("다른 사람이 선점한 경우에는 게임에 참가할 수 없습니다.");
    }

    @Test
    @DisplayName("hit이 나왔을 경우에 대한 테스트")
    void scenario_hit() {
        match.selectTeam("AWAY");
        match.play("hit");
        softly.assertThat(match.getMatchInfo().getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getOutCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(match.getMatchInfo().getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("hit을 연속으로 2번 냈을 경우에 대한 테스트")
    void scenario_hit_2() {
        match.selectTeam("AWAY");
        for (int i = 0; i < 2; i++) {
            match.play("hit");
        }
        softly.assertThat(match.getMatchInfo().getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getOutCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, true, false));
        softly.assertThat(match.getMatchInfo().getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("hit을 연속으로 3번 냈을 경우에 대한 테스트")
    void scenario_hit_3() {
        match.selectTeam("AWAY");
        for (int i = 0; i < 3; i++) {
            match.play("hit");
        }
        softly.assertThat(match.getMatchInfo().getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getStrikeCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getOutCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, true, true));
        softly.assertThat(match.getMatchInfo().getPitcherInfo())
                .isEqualTo(new ArrayList<>());
        softly.assertAll();
    }

    @Test
    @DisplayName("ball, strike, hit를 차례로 냈을 경우에 대한 테스트")
    void scenario_variety() {
        match.selectTeam("AWAY");
        match.play("ball");
        match.play("strike");
        match.play("hit");

        softly.assertThat(match.getMatchInfo().getHalvesCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getStrikeCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(1);
        softly.assertThat(match.getMatchInfo().getOutCount())
                .isEqualTo(0);
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(match.getMatchInfo().getPitcherInfo())
                .isEqualTo(Arrays.asList(false, true));
        softly.assertAll();
    }


    @Test
    @DisplayName("아웃이 3개 일어나면, 공수가 바뀌어야 한다.")
    void play_9strike_3out() {
        match.selectTeam("AWAY");
        softly.assertThat(match.getUserOffense())
                .isEqualTo(true);

        for (int i = 0; i < 9; i++) {
            match.play("strike");
        }

        softly.assertThat(match.getUserOffense())
                .isEqualTo(false);
        softly.assertAll();
    }

    @Test
    @DisplayName("공수가 2번 바뀌면, 이닝이 바뀌어야 한다.")
    void play_18strike_6out() {
        match.selectTeam("AWAY");
        softly.assertThat(match.getUserOffense())
                .isEqualTo(true);
        softly.assertThat(match.getMatchInfo().getInningCount())
                .isEqualTo(1);
        for (int i = 0; i < 9; i++) {
            match.play("strike");
        }
        softly.assertThat(match.getUserOffense())
                .isEqualTo(false);
        softly.assertThat(match.getMatchInfo().getInningCount())
                .isEqualTo(1);
        for (int i = 0; i < 9; i++) {
            match.play("strike");
        }
        softly.assertThat(match.getUserOffense()).
                isEqualTo(true);
        softly.assertThat(match.getMatchInfo().getInningCount())
                .isEqualTo(2);
        softly.assertAll();
    }

    @Test
    @DisplayName("HIT 이 발생하면, 1루 전진하고 공격 팀의 Batter 가 바뀌어야 한다.")
    void play_hit_changeBatter() {
        match.selectTeam("AWAY");
        softly.assertThat(match.getUserOffense())
                .isEqualTo(true);
        softly.assertThat(match.getTeams().getBatter().getName())
                .isEqualTo("AWAY1타자");

        match.play("hit");
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(match.getTeams().getBatter().getName())
                .isEqualTo("AWAY2타자");
        softly.assertAll();

    }

    @Test
    @DisplayName("Ball 이 4번 일어나면, 1루 전진하고 공격팀의 Batter 가 바뀌어야 한다.")
    void play_fourBall_changeBatter() {
        match.selectTeam("AWAY");
        softly.assertThat(match.getTeams().getBatter().getName())
                .isEqualTo("AWAY1타자");
        for (int i = 0; i < 4; i++) {
            match.play("ball");
        }
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, false, false));
        softly.assertThat(match.getTeams().getBatter().getName())
                .isEqualTo("AWAY2타자");
        softly.assertAll();
    }

    @Test
    @DisplayName("Ball 이 4번 일어나면, playResults 가 초기화 되어야 한다. 즉 ballCount가 다시 0이 되어야 한다.")
    void play_fourBall_resetPlayResults() {
        match.selectTeam("AWAY");
        match.play("ball");
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(1);
        for (int i = 0; i < 3; i++) {
            match.play("ball");
        }
        softly.assertThat(match.getMatchInfo().getBallCount())
                .isEqualTo(0);
        softly.assertAll();

    }

    @Test
    @DisplayName("3루가 true인 상태에서, HIT 이 일어나면 공격팀의 점수가 증가해야한다.")
    void play_hit_increaseScore() {
        // TODO:
        match.selectTeam("AWAY");
        softly.assertThat(match.getUserOffense())
                .isEqualTo(true);
        for (int i = 0; i < 3; i++) {
            match.play("hit");
        }
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, true, true));

        match.play("hit");
        softly.assertThat(match.getTeams().getAwayTeam().getScores())
                .isEqualTo(Arrays.asList(1));
        softly.assertAll();


    }

    @Test
    @DisplayName("3루가 true인 상태에서, BALL 이 4번 일어나면 공격팀의 점수가 증가해야한다.")
    void play_fourBall_increaseScore() {
        // TODO:
        match.selectTeam("AWAY");
        softly.assertThat(match.getUserOffense())
                .isEqualTo(true);
        for (int i = 0; i < 3; i++) {
            match.play("hit");
        }
        softly.assertThat(match.getMatchInfo().getBases())
                .isEqualTo(Arrays.asList(true, true, true));

        for (int i = 0; i < 4; i++) {
            match.play("ball");
        }
        softly.assertThat(match.getTeams().getAwayTeam().getScores())
                .isEqualTo(Arrays.asList(1));
        softly.assertAll();
    }
}
