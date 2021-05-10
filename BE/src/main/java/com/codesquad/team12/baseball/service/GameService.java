package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.repository.GameRepository;

import java.util.List;

public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

}
