package codesquad.baseball.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Inning {

    private int out;
    private int inningNumber;
    private String role;
    private String cycle;

    public Inning(int out, int inningNumber, String role, String cycle) {
        this.out = out;
        this.inningNumber = inningNumber;
        this.role = role;
        this.cycle = cycle;
    }

    public static Inning initiateInning(boolean isHome) {
        if (isHome) {
            return new Inning(0, 1, Constants.DEFENSE, Constants.TOP);
        }
        return new Inning(0, 1, Constants.OFFENSE, Constants.TOP);
    }

    public int updateOut(boolean isPlayerOut) {
        if (isPlayerOut) {
            this.out += 1;
        }
        return out;
    }

    private Inning changeRole() {
        if (this.role.equals(Constants.DEFENSE)) {
            this.role = Constants.OFFENSE;
            return this;
        }
        this.role = Constants.DEFENSE;
        return this;
    }

    private Inning changeCycle() {
        if (this.cycle.equals(Constants.TOP)) {
            this.cycle = Constants.BOTTOM;
            return this;
        }
        this.cycle = Constants.TOP;
        this.inningNumber += 1;
        return this;
    }

    public boolean needChange() {
        return this.out == Constants.MAX_OUT_NUMBER;
    }

    public Inning changeInning() {
        changeCycle();
        changeRole();
        this.out = 0;
        return this;
    }

    public int getOut() {
        return out;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public String getRole() {
        return role;
    }

    public String getCycle() {
        return cycle;
    }
}
