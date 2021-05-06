package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Score;
import baseball.domain.Team;
import baseball.repository.GameRepository;
import baseball.repository.TeamRepository;
import baseball.service.dto.GameDTO;
import baseball.service.dto.ScoresDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GameController {

    private static final int NUMBER_OF_TEAM = 10;

    private GameRepository gameRepository;
    private TeamRepository teamRepository;

    public GameController(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/games")
    public List<GameDTO> showGames() {

        // game team match
        List<Game> games = new ArrayList<>();
        for (long i = 1; i <= NUMBER_OF_TEAM; i += 2) {
            Team homeTeam = teamRepository.findById(i).orElseThrow(NoSuchElementException::new);
            Team awayTeam = teamRepository.findById(i + 1).orElseThrow(NoSuchElementException::new);
            Game game = new Game(homeTeam.getId(), awayTeam.getId());
            games.add(game);
        }
        gameRepository.saveAll(games);

        // convert to DTO
        List<GameDTO> gameDTOS = new ArrayList<>();
        for (Game game : games) {
            Long id = game.getId();
            Team homeTeam = teamRepository.findById(game.getHomeTeamId()).orElseThrow(NoSuchElementException::new);
            Team awayTeam = teamRepository.findById(game.getAwayTeamId()).orElseThrow(NoSuchElementException::new);
            GameDTO gameDTO = GameDTO.toGameDTO(id, homeTeam.getName(), awayTeam.getName());
            gameDTOS.add(gameDTO);
        }
        return gameDTOS;
    }

    @GetMapping("/games/{gameId}/scores")
    public ScoresDTO showScore(@PathVariable Long gameId) {

        // score 주기
        Game game = gameRepository.findById(gameId).orElseThrow(NoSuchElementException::new);
        Team homeTeam = teamRepository.findById(game.getHomeTeamId()).orElseThrow(NoSuchElementException::new);
        Team awayTeam = teamRepository.findById(game.getAwayTeamId()).orElseThrow(NoSuchElementException::new);

        Score firstScore = new Score(1, 1);
        Score secondScore = new Score(2, 1);
        homeTeam.setScore(firstScore);
        homeTeam.setScore(secondScore);

        teamRepository.save(homeTeam);

        Team team = teamRepository.findById(homeTeam.getId()).orElseThrow(NoSuchElementException::new);

        Set<Score> scores = team.getScores();

        return new ScoresDTO(team.getId(), scores);
    }
}
