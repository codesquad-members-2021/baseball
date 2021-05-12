package codesquad.team7.baseball.game;

import java.util.List;

public interface TeamInformation {
    void pitch();

    void hit();

    void out();

    void setNextBatter();

    void scoreUp(Integer ordinal);

    void nextInning();

    Integer getBatterNumber();

    Long getTeamId();

    String getTeamName();

    Integer getTotalScore();

    List<? extends PlayerStatistics> getPlayersStatistics();

    Pitcher getPitcher();

    List<Integer> getInningScore();
}
