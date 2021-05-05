package codesquad.team7.baseball.game;

public class BaseState {

    private Boolean first;
    private Boolean second;
    private Boolean third;
    private Boolean home;

    public BaseState(Boolean first, Boolean second, Boolean third, Boolean home) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.home = home;
    }

    public Boolean getFirst() {
        return first;
    }

    public Boolean getSecond() {
        return second;
    }

    public Boolean getThird() {
        return third;
    }

    public Boolean getHome() {
        return home;
    }

    public static BaseState newBaseState() {
        return new BaseState(
                false, false, false, false
        );
    }
}
