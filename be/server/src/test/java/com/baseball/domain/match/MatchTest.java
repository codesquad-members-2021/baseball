package com.baseball.domain.match;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.Teams;
import com.baseball.exception.MatchOccupiedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MatchTest {
    private Match match;

    @BeforeEach
    public void setUp() {
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
    @DisplayName("아웃이 3개 일어나면, 공수가 바뀌어야 한다.")
    void threeOut() {
        // TODO:
    }

    @Test
    @DisplayName("공수가 3번 바뀌면, 이닝이 바뀌어야 한다.")
    void changeInning() {
        // TODO:
    }

    @Test
    @DisplayName("HIT 이 발생하면, 1루 전진하고 공격 팀의 Batter 가 바뀌어야 한다.")
    void changeBatter_hit() {
        // TODO:
    }

    @Test
    @DisplayName("Ball 이 4번 일어나면, 1루 전진하고 공격팀의 Batter 가 바뀌어야 한다.")
    void changeBatter_fourBall() {
        // TODO:
    }

    @Test
    @DisplayName("Ball 이 4번 일어나면, playResults 가 초기화 되어야 한다. 즉 ballCount가 다시 0이 되어야 한다.")
    void resetPlayResults_fourBall() {
        // TODO:
    }

    @Test
    @DisplayName("만루인 상태에서, HIT 이 일어나면 공격팀의 점수가 증가해야한다.")
    void increaseScore_hit() {
        // TODO:
    }

    @Test
    @DisplayName("만루인 상태에서, BALL 이 4번 일어나면 공격팀의 점수가 증가해야한다.")
    void increaseScore_fourBall() {
        // TODO:
    }
}
