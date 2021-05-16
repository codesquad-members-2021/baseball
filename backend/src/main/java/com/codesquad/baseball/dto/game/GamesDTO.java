package com.codesquad.baseball.dto.game;

import java.util.List;

public class GamesDTO {
    private List<GameDTO> games;

    public GamesDTO(List<GameDTO> games) {
        this.games = games;
    }

    public List<GameDTO> getGames() {
        return games;
    }
}
