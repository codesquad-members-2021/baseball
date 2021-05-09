package com.team22.baseball.service;

import com.team22.baseball.dto.response.GameDto;
import com.team22.baseball.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> findAllGame() {
        return gameRepository.findAllGame();
    }
}
