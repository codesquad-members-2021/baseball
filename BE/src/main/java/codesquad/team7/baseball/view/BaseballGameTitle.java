package codesquad.team7.baseball.view;

public class BaseballGameTitle {

    private final Long gameId;
    private final String home;
    private final String away;

    private BaseballGameTitle(Long gameId, String home, String away) {
        this.gameId = gameId;
        this.home = home;
        this.away = away;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public static BaseballGameTitle of(Long gameId, String home, String away) {
        return new BaseballGameTitle(gameId, home, away);
    }
}
