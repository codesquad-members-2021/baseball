package com.codesquad.baseball.service;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public List<GameListDTO> browseAllGames() {
        return gameRepository.browseAllGames();
    }
}
