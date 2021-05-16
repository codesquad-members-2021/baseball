package baseball.service.dto;

import java.util.List;

public class Games {

    private List<GameDTO> games;

    public Games(List<GameDTO> games) {
        this.games = games;
    }

    public List<GameDTO> getGames() {
        return games;
    }
}
