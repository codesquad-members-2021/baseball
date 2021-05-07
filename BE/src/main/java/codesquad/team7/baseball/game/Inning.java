package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.Embedded;

public class Inning {

    private Integer ordinal;
    private TeamEnum attackTeam;
    private Integer batterNumber;

    private Integer strike;
    private Integer ball;
    private Integer out;

    @Embedded.Empty
    private BaseState baseState;

    Inning(Integer ordinal, TeamEnum attackTeam, Integer batterNumber, Integer strike, Integer ball, Integer out, BaseState baseState) {
        this.ordinal = ordinal;
        this.attackTeam = attackTeam;
        this.batterNumber = batterNumber;
        this.strike = strike;
        this.ball = ball;
        this.out = out;
        this.baseState = baseState;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public TeamEnum getAttackTeam() {
        return attackTeam;
    }

    public Integer getBatterNumber() {
        return batterNumber;
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

    public static Inning newInning() {
        return new Inning(
                1,
                TeamEnum.AWAY,
                0,
                0,
                0,
                0,
                BaseState.newBaseState()
        );
    }
}
