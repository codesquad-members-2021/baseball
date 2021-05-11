package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Constants {
    public final static String HIT_ACTION = "안타";
    public final static String OUT_ACTION = "아웃";
    public final static String FOUR_BALL_ACTION = "볼넷";

    public final static int MAX_OUT_NUMBER = 3;

    public final static String PITCHER = "투수";
    public final static String HITTER = "타자";
    static final String OFFENSE = "공격";
    static final String DEFENSE = "수비";
    static final String TOP = "초";
    static final String BOTTOM = "말";
}
