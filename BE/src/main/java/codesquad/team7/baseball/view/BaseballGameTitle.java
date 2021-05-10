package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.team.Team;

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

    public static BaseballGameTitle of(BaseballGame game) {
        return new BaseballGameTitle(game.getId(), game.getHomeTeamName(), game.getAwayTeamName());
    }
}
