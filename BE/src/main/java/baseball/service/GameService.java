package baseball.service;

import baseball.domain.Game;
import baseball.domain.Score;
import baseball.domain.Team;
import baseball.exception.GameNotFoundException;
import baseball.exception.TeamNotFoundException;
import baseball.repository.GameRepository;
import baseball.repository.TeamRepository;
import baseball.service.dto.GameDTO;
import baseball.service.dto.GameScoreDTO;
import baseball.service.dto.ScoreRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private static final int NUMBER_OF_TEAM = 10;

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public GameService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public GameDTO getGameDTOList() {
        if (gameRepository.count() != 5) {
            saveGames();
        }
        Iterable<Game> games = gameRepository.findAll();

        return new GameDTO(games);
    }

    private void saveGames() {
        List<Game> games = new ArrayList<>();

        for (long i = 1; i <= NUMBER_OF_TEAM; i += 2) {
            Team homeTeam = teamRepository.findById(i).orElseThrow(TeamNotFoundException::new);
            Team awayTeam = teamRepository.findById(i + 1).orElseThrow(TeamNotFoundException::new);

            Game game = new Game(homeTeam.getId(), awayTeam.getId());
            games.add(game);
        }
        gameRepository.saveAll(games);
    }

    public void saveScore(Long gameId, Long teamId, ScoreRequest scoreRequest) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new);
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);

        if (!game.isTeamInGame(team)) {
            throw new TeamNotFoundException();
        }
        Score newScore = scoreRequest.toScore();
        team.setScore(newScore);

        teamRepository.save(team);
    }

    public GameScoreDTO getGameScoreDTO(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new);

        Team homeTeam = teamRepository.findById(game.getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
        Team awayTeam = teamRepository.findById(game.getAwayTeamId()).orElseThrow(TeamNotFoundException::new);

        return new GameScoreDTO(game, homeTeam, awayTeam);
    }
}
