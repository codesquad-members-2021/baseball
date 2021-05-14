package baseball.service.dto;

import baseball.domain.Game;

import java.util.List;

public class GameDTO {

    private List<Game> games;

    public GameDTO(List<Game> games) {
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }
}
