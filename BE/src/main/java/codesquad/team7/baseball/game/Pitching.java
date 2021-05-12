package codesquad.team7.baseball.game;

public class Pitching {

    private static double HIT = 0.15;
    private static double BALL = 0.6;
    private static double STRIKE = 0.9;
    private static double OUT = 1;

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
