package baseball.service.dto;

import baseball.domain.Game;

import java.util.List;

public class GameDTO {

    private List<Game> games;

    public GameDTO(Iterable<Game> games) {
        this.games = (List<Game>) games;
    }

    public List<Game> getGames() {
        return games;
    }
}
