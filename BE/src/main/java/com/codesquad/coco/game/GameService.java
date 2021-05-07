package com.codesquad.coco.game;

import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.game.domain.DAO.ScoreBoardDAO;
import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.game.domain.model.Innings;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.team.domain.DTO.TeamPointDTO;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameDAO gameDAO;
    private ScoreBoardDAO boardDAO;

    public GameService(GameDAO gameDAO, ScoreBoardDAO boardDAO) {
        this.gameDAO = gameDAO;
        this.boardDAO = boardDAO;
    }

    public Game choiceGame(Long id) {
        return gameDAO.findById(id);
    }

    public ScoreBoard findScoreBoard(Long gameId, TeamPointDTO teamPointDTO) {
        return boardDAO.findByGameIdAndTeamName(gameId, teamPointDTO.getTeamName());
    }

    public void plusPoint(ScoreBoard scoreBoard, TeamPointDTO teamPointDTO) {
        Innings innings = scoreBoard.updateScore(teamPointDTO.getRound(), teamPointDTO.getPoint());
        boardDAO.saveInnings(innings);
    }
}
