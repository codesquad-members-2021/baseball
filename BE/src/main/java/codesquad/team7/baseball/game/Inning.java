package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.Embedded;

public class Inning {

    private Integer ordinal;
    private TeamEnum attackTeam;

    private Integer strike;
    private Integer ball;
    private Integer out;

    @Embedded.Empty
    private BaseState baseState;

    Inning(Integer ordinal, TeamEnum attackTeam, Integer strike, Integer ball, Integer out, BaseState baseState) {
        this.ordinal = ordinal;
        this.attackTeam = attackTeam;
        this.strike = strike;
        this.ball = ball;
        this.out = out;
        this.baseState = baseState;
    }

    public static Inning newInning() {
        return new Inning(
                1,
                TeamEnum.AWAY,
                0,
                0,
                0,
                BaseState.newBaseState()
        );
    }


    public boolean isScored() {
        return baseState.getHomeBase();
    }

    public void hit() {
        strike = 0;
        ball = 0;
        baseState.hit();
    }

    public void ball() {
        ball += 1;
        baseState.flushHome();
        if (ball >= 4) {
            ball = 0;
            baseState.fourBall();
        }
    }

    public void strike() {
        strike += 1;
        baseState.flushHome();
        if (strike >= 3) {
            strike = 0;
            out();
        }
    }

    public void out() {
        strike = 0;
        ball = 0;
        out += 1;
        baseState.flushHome();
        if (out >= 3) {
            out = 0;
            nextInning();
        }
    }

    private void nextInning() {
        baseState.nextInning();
        if (attackTeam == TeamEnum.AWAY) {
            attackTeam = TeamEnum.HOME;
            return;
        }

        if (attackTeam == TeamEnum.HOME) {
            attackTeam = TeamEnum.AWAY;
            ordinal += 1;
        }
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public TeamEnum getAttackTeam() {
        return attackTeam;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getOut() {
        return out;
    }

    public BaseState getBaseState() {
        return baseState;
    }
}
