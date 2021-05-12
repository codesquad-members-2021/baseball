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

    public boolean homeIn() {
        return baseState.getHomeBase();
    }

    public void hit() {
        baseState.hit();
    }

    public void ball() {
        ball += 1;
        baseState.flushHome();
    }

    public boolean isFourBall() {
        return ball >= 4;
    }

    public void fourBall() {
        baseState.fourBall();
    }

    public void out() {
        out += 1;
        baseState.flushHome();
    }

    public boolean isThreeOut() {
        return out >= 3;
    }

    public void threeOut() {
        out = 0;
        nextInning();
    }

    private void nextInning() {
        baseState.nextInning();

        if (attackTeam == TeamEnum.HOME) {
            ordinal += 1;
        }

        attackTeam = attackTeam.opposite();
    }

    public void strike() {
        strike += 1;
        baseState.flushHome();
    }

    public boolean isThreeStrike() {
        return strike >= 3;
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

    public String getHistoryState() {
        return strike + "-" + ball;
    }

    public void flushHome() {
        baseState.flushHome();
    }

    public void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public boolean canBeEndHomeWinner() {
        return out >= 3 && ordinal >= 9 && attackTeam == TeamEnum.AWAY ||
                ordinal >= 9 && attackTeam == TeamEnum.HOME;
    }

    public boolean canBeEndAwayWinner() {
        return out >= 3 && ordinal >= 9 && attackTeam == TeamEnum.HOME;
    }
}
