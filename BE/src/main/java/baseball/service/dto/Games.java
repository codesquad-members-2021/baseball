package baseball.service.dto;

import baseball.domain.Game;

import java.util.List;

public class Games {

    private List<Game> games;

    public Games(List<Game> games) {
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }
}
