package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.Embedded;

public class Inning {

    private Integer ordinal;
    private TeamEnum attacker;
    private Integer attackerNumber;

    private Integer strike;
    private Integer ball;
    private Integer out;

    @Embedded.Empty
    private BaseState baseState;

    Inning(Integer ordinal, TeamEnum attacker, Integer attackerNumber, Integer strike, Integer ball, Integer out, BaseState baseState) {
        this.ordinal = ordinal;
        this.attacker = attacker;
        this.attackerNumber = attackerNumber;
        this.strike = strike;
        this.ball = ball;
        this.out = out;
        this.baseState = baseState;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public TeamEnum getAttacker() {
        return attacker;
    }

    public Integer getAttackerNumber() {
        return attackerNumber;
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
                0,
                TeamEnum.AWAY,
                0,
                0,
                0,
                0,
                BaseState.newBaseState()
        );
    }
}
