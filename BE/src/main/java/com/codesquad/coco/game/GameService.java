package com.codesquad.coco.game;

import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.game.domain.DAO.ScoreBoardDAO;
import com.codesquad.coco.game.domain.model.DTO.GameScoreDTO;
import com.codesquad.coco.game.domain.model.Innings;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.team.domain.DTO.TeamPointDTO;
import com.codesquad.coco.team.domain.DTO.TeamScoreDTO;
import com.codesquad.coco.utils.DTOConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameDAO gameDAO;
    private ScoreBoardDAO boardDAO;

    public GameService(GameDAO gameDAO, ScoreBoardDAO boardDAO) {
        this.gameDAO = gameDAO;
        this.boardDAO = boardDAO;
    }

    public ScoreBoard findScoreBoardByTeamName(Long gameId, TeamPointDTO teamPointDTO) {
        return boardDAO.findByGameIdAndTeamName(gameId, teamPointDTO.getTeamName());
    }

    public void plusPoint(ScoreBoard scoreBoard, TeamPointDTO teamPointDTO) {
        Innings innings = scoreBoard.updateScore(teamPointDTO.getRound(), teamPointDTO.getPoint());
        boardDAO.saveInnings(innings);
    }

    public GameScoreDTO findGameScoreDTOByGameId(Long gameId) {
        List<ScoreBoard> scoreBoard = findScoreBoardByGameId(gameId);
        String userTeamName = findUserTeamNameByGameId(gameId);

        TeamScoreDTO teamScoreDTO = DTOConverter.scoreToTeamScoreDTO(scoreBoard.get(0));
        TeamScoreDTO teamScoreDTO1 = DTOConverter.scoreToTeamScoreDTO(scoreBoard.get(1));

        if (teamScoreDTO.getTeamName().equals(userTeamName)) {
            return new GameScoreDTO(teamScoreDTO, teamScoreDTO1);
        }
        return new GameScoreDTO(teamScoreDTO1, teamScoreDTO);
    }

    public List<ScoreBoard> findScoreBoardByGameId(Long gameId) {
        return boardDAO.findByGameId(gameId);
    }

    public String findUserTeamNameByGameId(Long gameId) {
        return gameDAO.findUserTeamNameByGameId(gameId);
    }


}
