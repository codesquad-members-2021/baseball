package codesquad.team7.baseball.game;

public class BaseState {

    private Boolean firstBase;
    private Boolean secondBase;
    private Boolean thirdBase;
    private Boolean homeBase;

    public BaseState(Boolean firstBase, Boolean secondBase, Boolean thirdBase, Boolean homeBase) {
        this.firstBase = firstBase;
        this.secondBase = secondBase;
        this.thirdBase = thirdBase;
        this.homeBase = homeBase;
    }

    public static BaseState newBaseState() {
        return new BaseState(
                false, false, false, false
        );
    }

    public Boolean getFirstBase() {
        return firstBase;
    }

    public Boolean getSecondBase() {
        return secondBase;
    }

    public Boolean getThirdBase() {
        return thirdBase;
    }

    public Boolean getHomeBase() {
        return homeBase;
    }

    public boolean hit() {
        homeBase = thirdBase;
        thirdBase = secondBase;
        secondBase = firstBase;
        firstBase = true;
        return homeBase;
    }

    public void fourBall() {
        if (!firstBase) {
            firstBase = true;
            return;
        }

        if (!secondBase) {
            secondBase = true;
            return;
        }

        if (!thirdBase) {
            thirdBase = true;
            return;
        }

        if (!homeBase) {
            homeBase = true;
        }
    }

    public void flushHome() {
        homeBase = false;
    }

    public void nextInning() {
        firstBase = false;
        secondBase = false;
        thirdBase = false;
        homeBase = false;
    }
}
