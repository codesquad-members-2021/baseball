package codesquad.team7.baseball.view;

import java.util.List;

public class BaseballGames {

    private final List<BaseballGameTitle> games;

    private BaseballGames(List<BaseballGameTitle> games) {
        this.games = games;
    }

    public List<BaseballGameTitle> getGames() {
        return games;
    }

    public static BaseballGames of(List<BaseballGameTitle> games) {
        return new BaseballGames(games);
    }
}
