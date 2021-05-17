package com.codesquad.baseball.service;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.DTO.record.TeamRecordDTO;
import com.codesquad.baseball.DTO.score.GameScoreDTO;
import com.codesquad.baseball.DTO.score.TeamScoreDTO;
import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.domain.Team;
import com.codesquad.baseball.error.exception.GameNotFoundException;
import com.codesquad.baseball.error.exception.TeamNotFoundException;
import com.codesquad.baseball.repository.GameRepository;
import com.codesquad.baseball.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public GameService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public List<GameListDTO> browseAllGames() {
        return gameRepository.browseAllGames();
    }

    public Game findGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
    }

    public Team findHomeTeamByGameId(Long id) {
        return teamRepository.findById(findGameById(id).getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
    }

    public Team findAwayTeamByGameId(Long id) {
        return teamRepository.findById(findGameById(id).getAwayTeamId()).orElseThrow(TeamNotFoundException::new);
    }

    public TeamRecordDTO browseTeamPlayersByGameId(Long id) {
        return new TeamRecordDTO(findAwayTeamByGameId(id), findHomeTeamByGameId(id));
    }

    public GameScoreDTO browseGameScoreByGameId(Long id) {
        return GameScoreDTO.of(findGameById(id), TeamScoreDTO.of(findHomeTeamByGameId(id)), TeamScoreDTO.of(findAwayTeamByGameId(id)));
    }
}
