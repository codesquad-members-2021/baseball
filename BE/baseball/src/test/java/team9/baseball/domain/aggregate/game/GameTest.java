package team9.baseball.domain.aggregate.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team9.baseball.domain.aggregate.team.Player;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;

class GameTest {
    private Team homeTeam;
    private Team awayTeam;
    private Game game;

    @BeforeEach
    void setUp() {
        homeTeam = new Team("코드스쿼드");
        homeTeam.setId(1);
        homeTeam.addPlayer(new Player("아이작", 1));
        homeTeam.addPlayer(new Player("쏭", 2));
        homeTeam.addPlayer(new Player("쑤", 3));
        homeTeam.addPlayer(new Player("쿠퍼", 4));
        homeTeam.addPlayer(new Player("우디", 5));

        awayTeam = new Team("마스터즈");
        awayTeam.setId(2);
        awayTeam.addPlayer(new Player("호눅스", 1));
        awayTeam.addPlayer(new Player("JK", 2));
        awayTeam.addPlayer(new Player("크롱", 3));
        awayTeam.addPlayer(new Player("세라", 4));
        awayTeam.addPlayer(new Player("헤드", 5));

        game = new Game(awayTeam, homeTeam);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strike() {
        assertInning(1, Halves.TOP);
        assertCountStatus(0, 0, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(1, 0, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(2, 0, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(0, 0, 1, 0, 0);
        assertPlayerStatus(1, 2, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(1, 0, 1, 0, 0);
        assertPlayerStatus(1, 2, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(2, 0, 1, 0, 0);
        assertPlayerStatus(1, 2, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(0, 0, 2, 0, 0);
        assertPlayerStatus(1, 3, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(1, 0, 2, 0, 0);
        assertPlayerStatus(1, 3, null, null, null);
        game.proceedStrike(awayTeam, homeTeam);
        assertCountStatus(2, 0, 2, 0, 0);
        assertPlayerStatus(1, 3, null, null, null);

        game.proceedStrike(awayTeam, homeTeam);
        assertInning(1, Halves.BOTTOM);
        assertCountStatus(0, 0, 0, 0, 0);
        assertPlayerStatus(4, 2, null, null, null);
    }

    @Test
    @DisplayName("볼 테스트")
    void ball() {
        assertInning(1, Halves.TOP);
        game.proceedBall(awayTeam, homeTeam);
        assertCountStatus(0, 1, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedBall(awayTeam, homeTeam);
        assertCountStatus(0, 2, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedBall(awayTeam, homeTeam);
        assertCountStatus(0, 3, 0, 0, 0);
        assertPlayerStatus(1, 1, null, null, null);
        game.proceedBall(awayTeam, homeTeam);
        assertCountStatus(0, 0, 0, 0, 0);
        assertPlayerStatus(1, 2, 1, null, null);

        for (int i = 0; i < 4; i++) {
            game.proceedBall(awayTeam, homeTeam);
        }
        assertPlayerStatus(1, 3, 2, 1, null);

        for (int i = 0; i < 4; i++) {
            game.proceedBall(awayTeam, homeTeam);
        }
        assertPlayerStatus(1, 4, 3, 2, 1);

        for (int i = 0; i < 4; i++) {
            game.proceedBall(awayTeam, homeTeam);
        }
        assertPlayerStatus(1, 5, 4, 3, 2);
        //득점 확인
        assertCountStatus(0, 0, 0, 1, 0);
    }

    void assertCountStatus(int strike, int ball, int out, int awayScore, int homeScore) {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(game.getStrikeCount()).isEqualTo(strike),
                () -> Assertions.assertThat(game.getBallCount()).isEqualTo(ball),
                () -> Assertions.assertThat(game.getOutCount()).isEqualTo(out),
                () -> Assertions.assertThat(game.getTotalScore(Halves.TOP)).isEqualTo(awayScore),
                () -> Assertions.assertThat(game.getTotalScore(Halves.BOTTOM)).isEqualTo(homeScore)
        );
    }

    void assertPlayerStatus(int pitcherNumber, int batterNumber, Integer base1UniformNumber, Integer base2UniformNumber, Integer base3UniformNumber) {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(game.getPitcherUniformNumber()).isEqualTo(pitcherNumber),
                () -> Assertions.assertThat(game.getBatterUniformNumber()).isEqualTo(batterNumber),
                () -> Assertions.assertThat(game.getBase1UniformNumber()).isEqualTo(base1UniformNumber),
                () -> Assertions.assertThat(game.getBase2UniformNumber()).isEqualTo(base2UniformNumber),
                () -> Assertions.assertThat(game.getBase3UniformNumber()).isEqualTo(base3UniformNumber)
        );
    }

    void assertInning(int currentInning, Halves currentHavles) {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(game.getCurrentInning()).isEqualTo(currentInning),
                () -> Assertions.assertThat(game.getCurrentHalves()).isEqualTo(currentHavles)
        );
    }
}
