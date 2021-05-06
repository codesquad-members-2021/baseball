package com.codesquad.coco.game;

import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.game.domain.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameDAO gameDAO;

    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    public Game choiceGame(Long id) {
        return gameDAO.findById(id);
    }
}
