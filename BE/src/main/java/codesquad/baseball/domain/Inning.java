package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Inning {

    private static final String OFFENSE = "공격";
    private static final String DEFENSE = "수비";
    private static final String TOP = "초";
    private static final String BOTTOM = "말";

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
            return new Inning(0, 1, DEFENSE, TOP);
        }
        return new Inning(0, 1, OFFENSE, TOP);
    }

    public int updateOut(boolean isPlayerOut) {
        if(isPlayerOut) {
            this.out += 1;
        }
        return out;
    }

    private Inning changeRole() {
        if (this.role.equals(DEFENSE)) {
            this.role = OFFENSE;
            return this;
        }
        this.role = DEFENSE;
        return this;
    }

    private Inning changeCycle() {
        if (this.cycle.equals(TOP)) {
            this.cycle = BOTTOM;
            return this;
        }
        this.role = TOP;
        this.inningNumber += 1;
        return this;
    }

    public boolean needChange() {
        return this.out == 3;
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
