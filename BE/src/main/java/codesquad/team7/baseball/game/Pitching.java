package codesquad.team7.baseball.game;

public class Pitching {

    private final static double HIT = 0.2;
    private final static double BALL = 0.6;
    private final static double STRIKE = 0.8;
    private final static double OUT = 1;

    public static Pitch pitch() {
        double random = Math.random();
        if (random < HIT) {
            return Pitch.HIT;
        }
        if (random < BALL) {
            return Pitch.BALL;
        }
        if (random < STRIKE) {
            return Pitch.STRIKE;
        }
        return Pitch.OUT;
    }
}
