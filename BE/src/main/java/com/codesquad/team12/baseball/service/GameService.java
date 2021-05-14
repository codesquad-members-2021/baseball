package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.dto.response.GameDto;
import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<GameDto> findAll() {
        return gameRepository
                .findAll()
                .stream()
                .map(Game::createGameDto)
                .collect(Collectors.toList());
    }
}
